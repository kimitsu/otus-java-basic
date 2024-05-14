package ru.otus.java.basic.hw5;

public class Cat extends Animal {
    boolean isSunk;

    public Cat(String name, double runSpeed, double endurance) {
        super(name, runSpeed, 0, endurance, 0);
    }

    @Override
    public double swim(int distance) {
        if (isSunk) {
            System.out.println(name + " уже утонул и дальше не поплывет");
            return -1;
        }
        if (endurance < 0) {
            System.out.println(name + " отдыхает и не полезет в воду");
            return -1;
        }
        System.out.println(name + " утонул");
        isSunk = true;
        return -1;
    }

    @Override
    public double run(int distance) {
        if (isSunk) {
            System.out.println(name + " уже утонул и дальше не побежит");
            return -1;
        }
        return super.run(distance);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Вид животного: кот");
        if (isSunk) {
            System.out.println(name + " утонул");
        }
    }
}
