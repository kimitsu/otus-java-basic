package ru.otus.java.basic.hw9.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectsTaskEvenIntegers {
    private ObjectsTaskEvenIntegers() {
    }

    public static List<Integer> evenIntegers(List<Integer> integers) {
        return integers.stream().filter(element -> element != null && element % 2 == 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Только чётные числа: " + evenIntegers(Arrays.asList(1, 2, 3, null, 44, 45, 46, null, null, -11, -12)));
    }
}