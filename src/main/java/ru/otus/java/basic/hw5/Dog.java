package ru.otus.java.basic.hw5;

public class Dog extends Animal {

    public Dog(String name, double runSpeed, double swimSpeed, double endurance) {
        super(name, runSpeed, swimSpeed, endurance, 2);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Вид животного: собака");
    }
}
