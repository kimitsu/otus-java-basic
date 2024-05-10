package ru.otus.java.basic.hw5.training;

import java.util.Arrays;

public class ArrayUtilsShiftElements {
    public static int[] shiftElements(int[] inputArray) {
        int[] result = new int[inputArray.length];
        if (inputArray.length == 0) return result;
        result[inputArray.length - 1] = inputArray[0];
        System.arraycopy(inputArray, 1, result, 0, inputArray.length - 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе массива [1, 2, 3, 4, 5], метод должен вернуть массив [2, 3, 4, 5, 1] - '"
                        + Arrays.toString(ArrayUtilsShiftElements.shiftElements(new int[]{1, 2, 3, 4, 5}))
                        + "'"
        );
    }
}