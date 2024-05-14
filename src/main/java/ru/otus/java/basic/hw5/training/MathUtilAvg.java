package ru.otus.java.basic.hw5.training;

public class MathUtilAvg {
    /**
     * Метод назван некорректно в задании
     * @param lowEdge
     * @param highEdge
     * @return
     */
    public static int getPrimeNumbersSum(byte lowEdge, byte highEdge) {
        int lowEdgeAdjusted = lowEdge % 2 == 0 ? lowEdge : lowEdge + 1;
        int highEdgeAdjusted = highEdge % 2 == 0 ? highEdge : highEdge - 1;
        if (highEdgeAdjusted < lowEdgeAdjusted) return 0;
        return (highEdgeAdjusted + lowEdgeAdjusted) / 2;
    }

    public static void main(String[] args) {
        System.out.println("avg четных чисел у ряда с 1 до 10 должен равняться 6 - "
                + MathUtilAvg.getPrimeNumbersSum((byte) 1, (byte) 10));
    }
}
