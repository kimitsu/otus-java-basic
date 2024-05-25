package ru.otus.java.basic.hw9.training;

import java.util.Arrays;
import java.util.List;

public class ObjectsTaskBuildList {
    private ObjectsTaskBuildList() {}

    public static <T> List<T> generateList(T... input) {
        return Arrays.stream(input).toList();
    }

    public static void main(String[] args) {
        System.out.println("Список разного: " + generateList(1, "2", '3', 4.5, false));
    }
}