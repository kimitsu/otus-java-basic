package ru.otus.java.basic.hw9;

public class Utils {
    public static void validateNotNull(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " is null");
        }
    }
}
