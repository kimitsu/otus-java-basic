package ru.otus.java.basic.hw5.training;

public class MathUtilArray {

    public static String getEvenNumbersUpTo(byte number) {
        if (number < 0) {
            return "";
        }
        if (number <= 1) {
            return "1";
        }

        StringBuilder result = new StringBuilder("1");
        for (int i = 2; i < number; i += 2) {
            result.append(i);
        }
        result.append(number);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Если передать число 5, то метод должен вернуть строку 1245 - " + MathUtilArray.getEvenNumbersUpTo((byte) 5));
    }
}