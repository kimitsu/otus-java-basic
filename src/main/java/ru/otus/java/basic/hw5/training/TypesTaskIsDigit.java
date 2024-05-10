package ru.otus.java.basic.hw5.training;

public class TypesTaskIsDigit {
    public static boolean isDigit(char input) {
        return input >= '0' && input <= '9';
    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе символа \"=\" метод должен вернуть false - '"
                        + TypesTaskIsDigit.isDigit('=')
                        + "'"
        );
    }
}