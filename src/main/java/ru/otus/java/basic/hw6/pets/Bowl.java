package ru.otus.java.basic.hw6.pets;

public class Bowl {
    private final double foodCapacity;
    private double foodAmount;

    /**
     * Creates a full bowl of cat food
     *
     * @param foodCapacity amount of food that can fit in a bowl
     * @throws IllegalArgumentException if foodCapacity is negative, infinite, or not a number
     */
    public Bowl(double foodCapacity) throws IllegalArgumentException {
        if (foodCapacity < 0 ||
                Double.isInfinite(foodCapacity) ||
                Double.isNaN(foodCapacity)) {
            throw new IllegalArgumentException();
        }
        this.foodCapacity = foodCapacity;
        this.foodAmount = foodCapacity;
    }

    /**
     * Fills the bowl up to capacity, overflowing food is spilled on the floor and is immediately eaten by mice
     *
     * @param foodToAdd amount of food to add
     * @throws IllegalArgumentException if foodToAdd is negative, infinite, or not a number
     */
    public void add(double foodToAdd) throws IllegalArgumentException {
        if (foodToAdd < 0 ||
                Double.isInfinite(foodToAdd) ||
                Double.isNaN(foodToAdd)) {
            throw new IllegalArgumentException();
        }
        System.out.printf("Adding %f units of food to the bowl.", foodToAdd);
        if (foodAmount + foodToAdd > foodCapacity) {
            System.out.printf(" %f units of food is spilled on the floor and eaten by mice.", foodAmount - foodCapacity + foodToAdd);
            foodAmount = foodCapacity;
        } else {
            foodAmount += foodToAdd;
        }
        System.out.printf(" The bowl now contains %f units of food.\n", foodAmount);
    }

    /**
     * Takes food out of the bowl, if the contained amount is sufficient
     * Does nothing if the specified amount is larger than the contained amount
     *
     * @param foodToTake amount of food to take out of the bowl
     * @return true if successful, false if the contained amount is insufficient
     * @throws IllegalArgumentException if foodToTake is negative, infinite, or not a number
     */
    public boolean take(double foodToTake) throws IllegalArgumentException {
        if (foodToTake < 0 ||
                Double.isInfinite(foodToTake) ||
                Double.isNaN(foodToTake)) {
            throw new IllegalArgumentException();
        }
        System.out.printf("Taking %f units of food out of the bowl.", foodToTake);
        if (foodAmount < foodToTake) {
            System.out.printf(" Failure due to insufficient food.\n");
            return false;
        }
        foodAmount -= foodToTake;
        System.out.printf(" Success, the bowl now contains %f food.\n", foodAmount);
        return true;
    }
}
