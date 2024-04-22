package ru.otus.java.basic.hw2;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class MainApplication {
    /**
     * Печатает строку несколько раз
     *
     * @param number количество раз
     * @param string строка, которую печатать
     */
    public static void printNumberAndString(int number, String string) {
        for (int i = 0; i < number; i++) {
            System.out.println(string);
        }
    }

    /**
     * Печатает сумму элементов массива, которые больше 5
     *
     * @param array входящий массив
     */
    public static void printSumOfElementsGreaterThanFive(int[] array) {
        long result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                result += array[i];
            }
        }
        System.out.println(result);
    }

    /**
     * Заполняет массив указанным значением
     *
     * @param array массив, который необходимо заполнить
     * @param value значение, которым необходимо заполнить массив
     */
    public static void fillArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    /**
     * Увеличивает элементы массива на указанное значение
     *
     * @param array массив, элементы которого необходимо увеличить
     * @param value значение, на которое необходимо увеличить элементы массива
     */
    public static void incrementArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value;
        }
    }

    /**
     * Печатает в консоль информацию о том, сумма элементов какой из половин входящего массива больше.
     * Половинами массива считаются его элементы [0..length/2-1] и [length/2..length-1]
     *
     * @param array входящий массив
     */
    public static void printCompareSumOfArrayHalves(int[] array) {
        if (array.length < 2) {
            System.out.println("Ваш массив слишком мал");
        } else {
            long result = 0;
            for (int i = 0; i < array.length / 2; i++) {
                result += array[i];
            }
            for (int i = array.length / 2; i < array.length; i++) {
                result -= array[i];
            }
            System.out.printf("Сумма элементов [0..%d] %s элементов [%d..%d]%n",
                    array.length / 2 - 1,
                    result > 0 ? "больше, чем сумма"
                            : (result < 0 ? "меньше, чем сумма"
                            : "равна сумме"),
                    array.length / 2,
                    array.length - 1);
        }
    }

    /**
     * Суммирует соответствующие элементы из нескольких массивов
     *
     * @param arrays перечень входящих массивов
     * @return массив длинной наибольшего из входящих массивов, каждый элемент которого
     * это сумма соответствующих элементов входящих массивов
     */
    public static int[] getArraySum(int[]... arrays) {
        // Получаем максимальную длину массива (пробуем функциональный паттерн)
        Optional<Integer> arraySize = Arrays.stream(arrays).map(array -> array.length).max(Integer::compare);
        if (arraySize.isPresent()) {
            int[] result = new int[arraySize.get()]; // при инициализации заполняется нулями
            for (int[] array : arrays) {
                for (int i = 0; i < array.length; i++) {
                    result[i] += array[i];
                }
            }
            return result;
        } else {
            // Нет входящих массивов
            return new int[0];
        }
    }

    /**
     * Находит первую "точку равновесия" массива, находящуюся между двумя соседними элементами массива,
     * суммы элементов массива по обе стороны от которой равны друг другу.
     *
     * @param array Входящий массив
     * @return OptionalInt, содержащий значение индекса первого из двух элементов массива,
     * между которыми располагается точка равновесия, если таковая имеется, или пустой в противном случае.
     */
    public static OptionalInt getBalancePoint(int[] array) {
        int sumRight = Arrays.stream(array).sum();
        int sumLeft = 0;
        for (int i = 0; i < array.length - 1; i++) {
            sumLeft += array[i];
            sumRight -= array[i];
            if (sumLeft == sumRight) {
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    /**
     * Проверяет, упорядочен ли массив
     *
     * @param array     Входящий массив
     * @param ascending true - по возрастанию, false - по убыванию
     * @param strict    true - строго, false - нестрого
     * @return true - если упорядочем в указанном направлении с указанной строгостью, false - в противном случае
     */
    public static boolean isOrdered(int[] array, boolean ascending, boolean strict) {
        // Для быстродействия лучше, видимо, продублировать циклы, чтобы не повторять проверки в цикле
        if (ascending && strict) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] <= array[i]) return false;
            }
        } else if (ascending) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) return false;
            }
        } else if (strict) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] >= array[i]) return false;
            }
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] > array[i]) return false;
            }
        }
        return true;
    }

    /**
     * Разворачивает массив
     *
     * @param array массив, который необходимо развернуть
     */
    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    /**
     * Простейший тестовый прогон методов
     *
     * @param args не используется
     */
    public static void main(String[] args) {

        printNumberAndString(5, "Hello...");

        printSumOfElementsGreaterThanFive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // 40

        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        fillArray(testArray, 10);
        System.out.println(Arrays.toString(testArray));

        testArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        incrementArray(testArray, 10);
        System.out.println(Arrays.toString(testArray));

        printCompareSumOfArrayHalves(testArray);

        System.out.println(
                Arrays.toString(
                        getArraySum(
                                new int[]{1, 2, 3},
                                new int[]{2, 2},
                                new int[]{1, 1, 1, 1, 1}
                        )
                )
        );

        System.out.println(getBalancePoint(new int[]{1, 5, 3, 4, -1}));

        System.out.println(isOrdered(new int[]{1, 2, 3, 4, 5}, true, true));

        testArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverseArray(testArray);
        System.out.println(Arrays.toString(testArray));

    }
}
