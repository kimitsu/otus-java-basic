package ru.otus.java.basic.hw1;

import java.util.Random;
import java.util.Scanner;

public class MainApplication {
    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        // Конвертируем в long с целью избежать ошибки при переполнении
        long sum = (long) a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        Random rng = new Random();
        int data = rng.nextInt(0, 30);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        Random rng = new Random();
        int a = rng.nextInt();
        int b = rng.nextInt();
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        long result;
        if (increment) {
            result = (long) initValue + delta;
        } else {
            result = (long) initValue - delta;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер метода (1-5): ");
        int choice;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            choice = 0;
        }
        if (choice == 1) {
            greetings();
        } else if (choice == 2) {
            Random rng = new Random();
            checkSign(rng.nextInt(), rng.nextInt(), rng.nextInt());
        } else if (choice == 3) {
            selectColor();
        } else if (choice == 4) {
            compareNumbers();
        } else if (choice == 5) {
            Random rng = new Random();
            addOrSubtractAndPrint(rng.nextInt(), rng.nextInt(), rng.nextBoolean());
        } else {
            System.out.println("Неверный ввод");
        }
    }
}
