package ru.otus.java.basic.hw5.training;

public class MathUtilFactorial {
    public static long getFactorial(byte number) {
        if (number < 0) {
            return 0;
        }
        long result = 1;
        for (byte i = 0; i < number; i++) {
            result *= i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Факториал от 5 должен равняться 120 - " + MathUtilFactorial.getFactorial((byte) 5));
    }
}
