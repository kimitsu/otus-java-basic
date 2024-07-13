package ru.otus.java.basic.hw19;

public abstract class Fruit {
    private final int weight;

    /**
     * Creates a fruit
     *
     * @param weight a weight of the fruit
     */
    public Fruit(int weight) {
        this.weight = weight;
    }

    /**
     * @return the weight of the fruit
     */
    public int getWeight() {
        return weight;
    }
}