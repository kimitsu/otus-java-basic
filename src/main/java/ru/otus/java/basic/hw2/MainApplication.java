package ru.otus.java.basic.hw2;

public class MainApplication {
    public static void printNumberAndString(int number, String string) {
        for (int i = 0; i < number; i++) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        printNumberAndString(5, "Hello...");
    }
}
