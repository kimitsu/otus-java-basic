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

    public static void main(String[] args) {

        System.out.println(sumOfPositiveElements(new int[][]{{0, 1, 2, 3}, {-1, -2, 3}, {}, {10, 20, 30, -40}}));

        printSquare(10);

    }

}
