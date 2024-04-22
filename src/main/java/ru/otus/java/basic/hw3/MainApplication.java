package ru.otus.java.basic.hw3;

import java.util.Arrays;
import java.util.OptionalInt;

public class MainApplication {
    /**
     * Возвращает сумму положительных элементов двумерного целочисленного массива
     *
     * @param array Входящий массив
     * @return Сумма положительных элементов входящего массива
     */
    public static long sumOfPositiveElements(int[][] array) {
        long result = 0;
        for (int[] row : array) {
            for (int item : row) {
                if (item > 0) {
                    result += item;
                }
            }
        }
        return result;
    }

    /**
     * Печатает ребра квадрата из символов "*" в консоль
     * и заполняет внутренность квадрата пробелами
     *
     * @param size Размер квадрата в символах
     */
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0 || j == size - 1 || i == 0 || i == size - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Зануляет диагональные элементы двумерного массива
     * Диагональными считаются элементы, у которых совпадает индекс в обоих измерениях
     *
     * @param array Входящий массив
     */
    public static void zeroDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array[i].length) {
                array[i][i] = 0;
            }
        }
    }

    /**
     * Возвращает OptionalInt, содержащий максимальный элемент двумерного массива, если таковой имеется,
     * или OptionalInt.empty() в противном случае (если массив пустой)
     *
     * @param array Входящий массив
     * @return OptionalInt со значением максимального элемента входящего массива, или пустой, если входящий массив пуст
     */
    public static OptionalInt findMax(int[][] array) {
        OptionalInt result = OptionalInt.empty();
        for (int[] row : array) {
            for (int item : row) {
                if (result.isEmpty() || item > result.getAsInt()) {
                    result = OptionalInt.of(item);
                }
            }
        }
        return result;
    }

    /**
     * Возвращает сумму элементов второй строки массива
     *
     * @param array Входящий массив
     * @return Сумма элементов второй строки входящего массива, или -1, если второй строки не существует
     */
    public static long sumOfElementsOfSecondRow(int[][] array) {
        return array.length >= 2 && array[1] != null ? Arrays.stream(array[1]).sum() : -1;
    }

    public static void main(String[] args) {

        System.out.println(sumOfPositiveElements(new int[][]{{0, 1, 2, 3}, {-1, -2, 3}, {}, {10, 20, 30, -40}}));

        printSquare(10);

        int[][] testArray = {{1, 2, 3}, {4, 5, 6, 7}, {}, {8, 9, 10, 11}, {12, 13, 14, 15, 16, 17}};
        zeroDiagonal(testArray);
        Arrays.stream(testArray).forEach(x -> System.out.println(Arrays.toString(x)));

        System.out.println("findMax(testArray) = " + findMax(testArray));

        System.out.println("sumOfElementsOfSecondRow(testArray) = " + sumOfElementsOfSecondRow(testArray));

    }

}
