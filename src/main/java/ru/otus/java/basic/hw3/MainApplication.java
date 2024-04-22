package ru.otus.java.basic.hw3;

public class MainApplication {
    /**
     * Возвращает сумму положительных элементов двумерного целочисленного массива
     *
     * @param array Входной массив
     * @return Сумма положительных элементов входного массива
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
}
