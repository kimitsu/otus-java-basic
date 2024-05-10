package ru.otus.java.basic.hw5.training;

public class TypesTaskSumN {
    public static long sumN(int input) {
        return input < 1 ? 0 : input * ((long) 1 + input) / 2;
    }

    private TypesTaskSumN() {

    }

    public static void main(String[] args) {
        System.out.println(
                "Ввод меньше 1 должен вернуть 0: " +
                        sumN(-1)
        );
        System.out.println(
                "Сумма от 1 до 7: " +
                        sumN(7)
        );
    }
}