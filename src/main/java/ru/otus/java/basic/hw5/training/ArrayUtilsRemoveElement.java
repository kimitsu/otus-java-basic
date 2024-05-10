package ru.otus.java.basic.hw5.training;

import java.util.Arrays;

public class ArrayUtilsRemoveElement {
    public static int[] removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
            }
        }
        int[] result = new int[count];
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                result[count] = nums[i];
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе массива [1, 1, 2, 3, 1] и числа 1, метод должен вернуть [2, 3] - '"
                        + Arrays.toString(ArrayUtilsRemoveElement.removeElement(new int[]{1, 1, 2, 3, 1}, 1))
                        + "'"
        );
    }
}