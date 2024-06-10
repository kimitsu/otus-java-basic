package ru.otus.java.basic.hw11.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestSortUtils {
    /**
     * Tests of sorting methods
     *
     * @param args unused
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{27, 15, 38, 65, 92, 19, 74, 87, 57, 51});
        System.out.println("list = " + list);
        SortUtils.bubbleSort(list, Comparator.naturalOrder());
        System.out.println("bubbleSort: list = " + list);

        list = Arrays.asList(new Integer[]{27, 15, 38, 65, 92, 19, 74, 87, 57, 51});
        System.out.println("list = " + list);
        SortUtils.quickSort(list, Comparator.naturalOrder());
        System.out.println("quickSort: list = " + list);

        list = Arrays.asList(new Integer[]{27, 15, 31});
        System.out.println("list = " + list);
        SortUtils.quickSort(list, Comparator.naturalOrder());
        System.out.println("quickSort: list = " + list);

        list = Arrays.asList(new Integer[]{37, 15, 1});
        System.out.println("list = " + list);
        SortUtils.quickSort(list, Comparator.naturalOrder());
        System.out.println("quickSort: list = " + list);

        list = Arrays.asList(new Integer[]{3, 2, 1, 4, 5, -1});
        System.out.println("list = " + list);
        SortUtils.quickSort(list, Comparator.naturalOrder());
        System.out.println("quickSort: list = " + list);

        list = Arrays.asList(new Integer[]{137, 15, 1, 123, 2, 523, 2634, 234, 623, 72, 47, 83, 22, 245, 245, 22, 75, 18, 272});
        System.out.println("list = " + list);
        SortUtils.quickSort(list, Comparator.reverseOrder());
        System.out.println("quickSort: list = " + list);
    }
}
