package ru.otus.java.basic.hw7.transport;

public class Utils {
    /**
     * Checks if the value is not a finite non-negative number
     *
     * @param value number to check
     * @return true if the number is negative or infinite
     */
    static boolean isIllegal(double value) {
        return value < 0 || !Double.isFinite(value);
    }
}
