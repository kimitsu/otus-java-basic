package ru.otus.java.basic.hw5.training;

import java.util.Arrays;

public class FunctionUtilsGetMax {
    public static int getMax(int... numbers) {
        return Arrays.stream(numbers).max().orElse(0);
    }

    private FunctionUtilsGetMax() {

    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе массива [1, 6, 9, 0, 15, 3], метод должен вернуть число 15 - '"
                        + FunctionUtilsGetMax.getMax(1, 6, 9, 0, 15, 3)
                        + "'"
        );
    }
}