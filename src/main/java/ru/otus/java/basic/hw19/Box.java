package ru.otus.java.basic.hw19;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    /**
     * Creates an empty box
     */
    public Box() {
    }

    /**
     * Adds a fruit to the box
     *
     * @param fruit a fruit to add
     * @throws NullPointerException if the fruit is null
     */
    public void add(T fruit) {
        if (fruit == null) {
            throw new NullPointerException("fruit must not be null");
        }
        fruits.add(fruit);
    }

    /**
     * Adds a list of fruits to the box
     *
     * @param fruitsList a list of fruits to add
     * @throws NullPointerException if the fruit is null
     */
    public void add(List<? extends T> fruitsList) {
        if (fruitsList == null) {
            throw new NullPointerException("fruitsList must not be null");
        }
        fruits.addAll(fruitsList);
    }

    /**
     * @return the weight of the contents of the box
     */
    private int getWeight() {
        int totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    /**
     * Compares the weights of the contents of the box to another box
     *
     * @param otherBox a box to compare to
     * @return true if the weights are equal, false otherwise
     */
    public boolean compare(Box<?> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    /**
     * Dumps the contents of the box into another box
     *
     * @param otherBox a box to dump into
     */
    public void dumpInto(Box<? super T> otherBox) {
        if (otherBox == null || otherBox == this) {
            throw new IllegalArgumentException("otherBox should not be this or null");
        }
        otherBox.add(fruits);
        fruits.clear();
    }
}
