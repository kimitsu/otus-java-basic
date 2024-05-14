package ru.otus.java.basic.hw6.pets;

public class Bowl {
    final double foodCapacity;
    double foodAmount;

    /**
     * Creates a full bowl of cat food
     *
     * @param foodCapacity amount of food that can fit in a bowl
     */
    public Bowl(double foodCapacity) {
        this.foodCapacity = foodCapacity;
        foodAmount = foodCapacity;
    }

    /**
     * Fills the bowl up to capacity, leftover food is spilled
     *
     * @param foodAmount amount of food to add
     */
    public void add(double foodAmount) {
        System.out.printf("Adding %f units of food to the bowl.", foodAmount);
        this.foodAmount += foodAmount;
        if (this.foodAmount > foodCapacity) {
            System.out.printf(" %f units of food is spilled.", this.foodAmount - foodCapacity);
            this.foodAmount = foodCapacity;
        }
        System.out.printf(" The bowl now contains %f units of food.\n", this.foodAmount);
    }

    /**
     * Takes food out of the bowl, if the contained amount is sufficient
     * Does nothing if the specified amount is larger than the contained amount
     *
     * @param foodAmount amount of food to take out of the bowl
     * @return true if successful, false if the contained amount is insufficient
     */
    public boolean take(double foodAmount) {
        System.out.printf("Taking %f units of food out of the bowl.", foodAmount);
        if (this.foodAmount < foodAmount) {
            System.out.printf(" Failure due to insufficient food.\n");
            return false;
        }
        this.foodAmount -= foodAmount;
        System.out.printf(" Success, the bowl now contains %f food.\n", this.foodAmount);
        return true;
    }
}
