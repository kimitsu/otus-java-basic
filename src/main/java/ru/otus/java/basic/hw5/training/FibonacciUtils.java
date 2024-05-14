package ru.otus.java.basic.hw5.training;

import java.math.BigInteger;

public class FibonacciUtils {
    public static String getFibonacciSum(byte limit) {
        if (limit <= 1) {
            return "0";
        }
        if (limit <= 2) {
            return "1";
        }
        BigInteger previousFibonacci = new BigInteger("0");
        BigInteger currentFibonacci = new BigInteger("1");
        BigInteger summFibonacci = new BigInteger("1");
        for (int i = 2; i < limit; i++) {
            BigInteger newFibonacci = currentFibonacci.add(previousFibonacci);
            previousFibonacci = currentFibonacci;
            currentFibonacci = newFibonacci;
            summFibonacci = summFibonacci.add(currentFibonacci);
        }
        return summFibonacci.toString();
    }

    public static void main(String[] args) {
        System.out.println("Сумма чисел фибоначчи до 5 должна равняться 7 - " + FibonacciUtils.getFibonacciSum((byte) 127));
    }
}