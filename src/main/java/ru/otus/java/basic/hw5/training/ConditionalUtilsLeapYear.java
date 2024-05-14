package ru.otus.java.basic.hw5.training;

public class ConditionalUtilsLeapYear {
    public static boolean isLeapYear(int inputYear) {

        return inputYear % 4 == 0 && (inputYear % 100 != 0 || inputYear % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println("При вводе числа 2004, метод должен вернуть true - " + ConditionalUtilsLeapYear.isLeapYear(2004));
    }
}