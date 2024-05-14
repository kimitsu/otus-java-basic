package ru.otus.java.basic.hw5.training;

import java.util.*;

public class ArrayUtilsFindNumberPosition {
    public static int[] findNumberPosition(int[][] input, int number) {
        for (int i = input.length - 1; i >= 0; i--) {
            for (int j = input[i].length - 1; j >= 0; j--) {
                if (input[i][j] == number) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{5, 7, 3, 17}, {7, 0, 1, 12}};
        System.out.println(
                "При вводе массива [[5, 7, 3, 17], [7, 0, 1, 12]] и числа 7, метод должен вернуть массив [1, 0] - '"
                        + Arrays.toString(ArrayUtilsFindNumberPosition.findNumberPosition(input, 7))
                        + "'"
        );
    }
}