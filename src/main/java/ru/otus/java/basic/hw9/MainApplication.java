package ru.otus.java.basic.hw9;

import ru.otus.java.basic.hw9.employee.EmployeeRoster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {

    /**
     * Creates an ArrayList filled with sequential integer numbers ranging from min to max, min and max included
     *
     * @param min the first number of the sequence
     * @param max the last number of the sequence
     * @return sequence of integer numbers ranging from min up to max, min and max included,
     * or empty sequence if max is less than min
     */
    public static ArrayList<Integer> getRange(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        if (max < min) {
            return result;
        }
        result.ensureCapacity(max - min);
        for (int i = min; i <= max; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * Calculates the sum of integers greater than five
     *
     * @param list list of integers to calculate the sum of
     * @return sum of integers greater than five
     */
    public static long getSumGreaterThanFive(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        return list.stream().filter(value -> value != null && value > 5).reduce(0, Integer::sum);
    }

    /**
     * Fill non-empty cells of a list with a value
     *
     * @param list  a list to fill
     * @param value a value to set non-empty cells to
     * @param <T>   class of the values of the list
     */
    public static <T> void fillElements(List<T> list, T value) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.set(i, value);
            }
        }
    }

    /**
     * Increase non-empty elements of a list by a value
     *
     * @param list  a list to alter
     * @param value a value to increase the elements of the list by
     */
    public static void increaseElements(List<Integer> list, int value) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        for (int i = 0; i < list.size(); i++) {
            Integer element = list.get(i);
            if (element != null) {
                list.set(i, element + value);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("getRange(-10, 10) = " + getRange(-10, 10));
        System.out.println("getSumGreaterThanFive(getRange(-10, 10)) = " + getSumGreaterThanFive(getRange(-10, 10)));
        List<Integer> testList = Arrays.asList(1, 2, 3, null, 5, 6, null, 9);
        System.out.println("testList = " + testList);
        fillElements(testList, 10);
        System.out.println("fillElements(testList, 10); testList = " + testList);
        testList = Arrays.asList(1, 2, 3, null, 5, 6, null, 9);
        System.out.println("testList = " + testList);
        increaseElements(testList, 3);
        System.out.println("increaseElements(testList, 1); testList = " + testList);
        EmployeeRoster.main(args);
    }
}
