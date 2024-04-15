package ru.otus.java.basic.hw2;

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

    public static void main(String[] args) {
        printNumberAndString(5, "Hello...");
        printSumOfElementsGreaterThanFive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // Must print 40
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        fillArray(testArray, 10);
        printSumOfElementsGreaterThanFive(testArray); // Must print 100
    }
}
