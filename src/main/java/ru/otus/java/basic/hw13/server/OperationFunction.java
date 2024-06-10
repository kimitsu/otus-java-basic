package ru.otus.java.basic.hw13.server;

@FunctionalInterface
public interface OperationFunction {
    /**
     * Operates on two numbers
     *
     * @param a number a
     * @param b number b
     * @return result of the operation between a and b
     */
    int operate(int a, int b);
}
