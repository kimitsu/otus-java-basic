package ru.otus.java.basic.hw22;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(IntArrayProcessor.getTrimmedUntilLastOne(new int[]{1, 2, 3})));
    }

    private MainApplication() {
    }
}
