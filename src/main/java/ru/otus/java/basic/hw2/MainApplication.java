package ru.otus.java.basic.hw2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class MainApplication {
    public static void printNumberAndString(int number, String string) {
        for (int i = 0; i < number; i++) {
            System.out.println(string);
        }
    }

    public static void printSumOfElementsGreaterThanFive(int[] array) {
        long result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                result += array[i];
            }
        }
        System.out.println(result);
    }

    public static void fillArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public static void incrementArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value;
        }
    }

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

    public static void main(String[] args) {
        printNumberAndString(5, "Hello...");
        printSumOfElementsGreaterThanFive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // Must print 40
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
    }
}
