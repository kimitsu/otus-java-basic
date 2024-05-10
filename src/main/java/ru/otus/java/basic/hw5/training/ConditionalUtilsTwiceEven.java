package ru.otus.java.basic.hw5.training;

public class ConditionalUtilsTwiceEven {
    public static boolean isDoublePrime(int inputNumber) {
        if (inputNumber < 100 || inputNumber > 999) {
            return false;
        }
        int sumDigits = 0;
        for (int i = 0; i < 3; i++) {
            int digit = inputNumber % 10;
            inputNumber = inputNumber / 10;
            sumDigits += digit;
        }
        // Трехзначное число с четной суммой цифр гарантированно имеет четное произведение цифр
        return sumDigits % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println("При вводе числа 222 метод должен вернуть true - " + ConditionalUtilsTwiceEven.isDoublePrime(222));
    }
}
