package ru.otus.java.basic.hw5;

import java.util.Arrays;

public class ObstacleCourse {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Шарик", 10, 2, 80),
                new Horse("Буцефал", 15, 4, 50),
                new Cat("Матроскин", 20, 40),
                new Dog("Бася", 5, 4, 50),
                new Horse("Плотва", 20, 10, 100),
                new Cat("Гарфилд", 3, 5),
        };
        Arrays.stream(animals).forEach(animal -> {
            animal.info();
            System.out.println();
        });
        Arrays.stream(animals).forEach(animal -> animal.run(10));
        System.out.println();
        Arrays.stream(animals).forEach(animal -> animal.swim(5));
        System.out.println();
        Arrays.stream(animals).forEach(animal -> animal.run(20));
        System.out.println();
        Arrays.stream(animals).forEach(animal -> animal.swim(10));
        System.out.println();
        Arrays.stream(animals).forEach(animal -> {
            animal.info();
            System.out.println();
        });
    }
}
