package ru.otus.java.basic.hw5;

public class Horse extends Animal {
    public Horse(String name, double runSpeed, double swimSpeed, double endurance) {
        super(name, runSpeed, swimSpeed, endurance, 4);
    }
    
    @Override
    public void info() {
        super.info();
        System.out.println("Вид животного: лошадь");
    }
}

