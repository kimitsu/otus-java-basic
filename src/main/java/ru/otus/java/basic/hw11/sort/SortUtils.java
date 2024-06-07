package ru.otus.java.basic.hw11.sort;

import ru.otus.java.basic.hw11.Utils;

import java.util.Comparator;
import java.util.List;

public class SortUtils {
    /**
     * Sorts the list using bubble sort method
     *
     * @param list       a list to sort
     * @param comparator a comparator to use for sorting
     * @param <T>        class of objects contained in the list
     */
    public static <T> void bubbleSort(List<T> list, Comparator<T> comparator) {
        Utils.validateNotNull(list, "list");
        Utils.validateNotNull(comparator, "comparator");
        for (int i = list.size(); i > 1; i--) {
            boolean touched = false;
            for (int j = 1; j < i; j++) {
                T left = list.get(j - 1);
                T right = list.get(j);

                if (comparator.compare(left, right) > 0) {
                    touched = true;
                    list.set(j - 1, right);
                    list.set(j, left);
                }
            }
            if (!touched) {
                return;
            }
        }
    }

    /**
     * Sorts the list using quick sort method
     *
     * @param list       a list to sort
     * @param comparator a comparator to use for sorting
     * @param <T>        class of objects contained in the list
     */
    public static <T> void quickSort(List<T> list, Comparator<T> comparator) {
        Utils.validateNotNull(list, "list");
        Utils.validateNotNull(comparator, "comparator");
        quickSortSection(list, comparator, 0, list.size() - 1);
    }

    /**
     * Partitions a section of a list into two subsections,
     * such that any element from the first subsection is less or equal to any element from the second subsection
     *
     * @param list       a list to partition
     * @param comparator a comparator to use
     * @param start      an index of the leftmost element of a section to partition, start of the first subsection
     * @param end        an index of the rightmost element of a section to partition, end of the second subsection
     * @param <T>        class of objects contained in the list
     * @return index of the first element of the second subsection
     */
    private static <T> int partition(List<T> list, Comparator<T> comparator, int start, int end) {
        T pivot = list.get(start);
        int left = start;
        int right = end;
        while (true) {
            while (left <= end && comparator.compare(list.get(left), pivot) < 0) left++;
            while (right > left && comparator.compare(list.get(right), pivot) >= 0) right--;
            if (left > end) return start + 1;
            if (right <= start) return start + 1;
            if (left >= right) return left;
            T element = list.get(left);
            list.set(left, list.get(right));
            list.set(right, element);
            left += 1;
            right -= 1;
        }
    }

    /**
     * Sorts a section of the list
     *
     * @param list       a list to sort
     * @param comparator a comparator to use for sorting
     * @param start      an index of the leftmost element of the section to sort
     * @param end        an index of the rightmost element of the section to sort
     * @param <T>        class of object contained in the list
     */
    private static <T> void quickSortSection(List<T> list, Comparator<T> comparator, int start, int end) {
        if (end <= start) return;
        if (end == start + 1) {
            T left = list.get(start);
            T right = list.get(end);
            if (comparator.compare(left, right) > 0) {
                list.set(start, right);
                list.set(end, left);
            }
            return;
        }
        int pivot = partition(list, comparator, start, end);
        quickSortSection(list, comparator, start, pivot - 1);
        quickSortSection(list, comparator, pivot, end);
    }
}
