package ru.otus.java.basic.hw13.training;

public class ExceptionTaskBuggyMethod {
    private ExceptionTaskBuggyMethod() {
    }

    public static int buggyMethod(Integer[] inputNumbers) {
        int result = 0;
        try {
            for (var item : inputNumbers) {
                try {
                    result += (item + 1) / item;
                } catch (ArithmeticException e) {
                }
            }
        } catch (NullPointerException e) {
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("buggyMethod(null) = " + buggyMethod(null));
        System.out.println("buggyMethod(new Integer[]{1, 0}) = " + buggyMethod(new Integer[]{1, 0}));
    }
}