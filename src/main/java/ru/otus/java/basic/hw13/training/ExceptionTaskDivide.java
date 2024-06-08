package ru.otus.java.basic.hw13.training;

import java.util.Arrays;

public class ExceptionTaskDivide {
    private ExceptionTaskDivide() {
    }

    public static int[] divide(int... numbers) {
        if (numbers.length % 2 != 0) {
            throw new IllegalArgumentException("number of arguments should be even");
        }
        int[] result = new int[numbers.length / 2];
        for (int i = 0; i < result.length; i += 1) {
            try {
                result[i] = numbers[i * 2] / numbers[i * 2 + 1];
            } catch (ArithmeticException _) {
                result[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Делим попарно 4, 2, 4, 1: " + Arrays.toString(divide(4, 2, 4, 1)));
        System.out.println("Делим попарно 0, 2, 0, 0: " + Arrays.toString(divide(0, 2, 0, 0)));
    }
}