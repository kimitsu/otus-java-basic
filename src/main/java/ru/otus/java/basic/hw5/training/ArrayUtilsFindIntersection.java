package ru.otus.java.basic.hw5.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayUtilsFindIntersection {

    public static int[] findIntersection(int[] rightArray, int[] leftArray) {
        int[] leftSorted = leftArray.clone();
        Arrays.sort(leftSorted);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < rightArray.length; i++) {
            int j = Arrays.binarySearch(leftSorted, rightArray[i]);
            if (j >= 0) {
                final int k = i;
                if (result.stream().filter(element -> (element == rightArray[k])).findAny().isEmpty()) {
                    result.add(rightArray[i]);
                }
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private ArrayUtilsFindIntersection() {

    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе массивов [1,4,7,3,8] и [9,12,7,4] метод должен вернуть массив [4,7] - '"
                        + Arrays.toString(ArrayUtilsFindIntersection.findIntersection(new int[]{1, 4, 7, 3, 8, -1, 1, 1}, new int[]{1, 1, 9, 12, 7, 4, -1}))
                        + "'"
        );
    }
}