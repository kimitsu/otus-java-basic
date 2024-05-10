package ru.otus.java.basic.hw5.training;

public class ConditionalUtilsFlatNumber {
    public static boolean isDescendingNumber(int inputNumber) {
        if (inputNumber < 100 || inputNumber > 999) {
            return false;
        }
        return inputNumber % 111 == 0;
    }

    public static void main(String[] args) {
        System.out.println("При вводе числа 777 метод должен вернуть true - " + ConditionalUtilsFlatNumber.isDescendingNumber(777));
    }
}