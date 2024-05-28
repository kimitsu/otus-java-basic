package ru.otus.java.basic.hw10;

public class Utils {
    /**
     * Checks if the value and throws IllegalArgumentException if it's null
     *
     * @param value value to check
     * @param name  name of the value which will be specified in the error message
     */
    public static void validateNotNull(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " is null");
        }
    }
}
