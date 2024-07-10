package ru.otus.java.basic.hw19;

public class MainApplication {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        fruitBox.add(new Apple(2));
        fruitBox.add(new Apple(3));
        fruitBox.add(new Orange(4));

        appleBox.add(new Apple(3));
        appleBox.add(new Apple(3));
        appleBox.add(new Apple(3));

        orangeBox.add(new Orange(4));
        orangeBox.add(new Orange(4));
        orangeBox.add(new Orange(4));

        System.out.println("fruitBox.compare(appleBox) = " + fruitBox.compare(appleBox));
        System.out.println("appleBox.compare(orangeBox) = " + appleBox.compare(orangeBox));

        appleBox.dumpInto(fruitBox);
        orangeBox.dumpInto(fruitBox);
        System.out.println("Dumped apples and oranges from their boxes.");

        System.out.println("appleBox.compare(orangeBox) = " + appleBox.compare(orangeBox));
    }
}
