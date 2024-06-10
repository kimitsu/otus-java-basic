package ru.otus.java.basic.hw13.server;

public enum Operation {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);
    private final String name;
    private final OperationFunction function;

    Operation(String name, OperationFunction function) {
        this.name = name;
        this.function = function;
    }

    /**
     * Operates on two numbers
     *
     * @param a number a
     * @param b number b
     * @return result of the operation between a and b
     */
    public int operate(int a, int b) {
        return function.operate(a, b);
    }

    /**
     * @return symbolic name of the operation
     */
    public String getName() {
        return name;
    }
}
