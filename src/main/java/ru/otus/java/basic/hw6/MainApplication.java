package ru.otus.java.basic.hw6;

import ru.otus.java.basic.hw6.pets.Bowl;
import ru.otus.java.basic.hw6.pets.Cat;

public class MainApplication {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Tom", 7.0),
                new Cat("Puss-in-Boots", 4.0),
                new Cat("Garfield", 13.0),
                new Cat("Hello-Kitty", 5.0),
        };
        Bowl bowl = new Bowl(20.0);

        System.out.println("\nRound 1:");
        for (Cat cat : cats) {
            cat.feed(bowl);
        }

        System.out.println("\nPreliminary results:");
        for (Cat cat : cats) {
            cat.info();
        }

        System.out.println("\nRound 2:");
        bowl.add(20.0);
        for (Cat cat : cats) {
            cat.feed(bowl);
        }

        System.out.println("\nConclusion:");
        for (Cat cat : cats) {
            cat.info();
        }
    }
}
