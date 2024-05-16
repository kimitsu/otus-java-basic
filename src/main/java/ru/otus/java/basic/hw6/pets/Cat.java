package ru.otus.java.basic.hw6.pets;

import ru.otus.java.basic.hw6.pets.Bowl;

public class Cat {
    private final String name;
    private final double appetite;
    private boolean isFed;

    /**
     * Creates a hungry cat
     *
     * @param name     name of the cat
     * @param appetite amount of food the cat needs to eat per feeding session
     * @throws IllegalArgumentException if name is null or appetite is negative, infinite or not a number
     */
    public Cat(String name, double appetite) throws IllegalArgumentException {
        if (name == null || appetite < 0 || Double.isInfinite(appetite) || Double.isNaN(appetite)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.appetite = appetite;
        this.isFed = false;
    }

    /**
     * Attempts to feed the cat from a bowl
     * The cat does not eat if the bowl contains insufficient food, or if it is already fed
     *
     * @param bowl the bowl to feed the cat from
     * @return true if successful, false if already fed or if the amount of food in the bowl is insufficient
     * @throws IllegalArgumentException if bowl is null
     */
    public boolean feed(Bowl bowl) throws IllegalArgumentException {
        if (bowl == null) {
            throw new IllegalArgumentException();
        }
        if (isFed) {
            System.out.printf("%s approaches the bowl with disinterest. It is already fed.\n", name);
            return false;
        }
        System.out.printf("%s approaches the bowl. Attempting to eat %f units of food.\n", name, appetite);
        isFed = bowl.take(appetite);
        if (isFed) {
            System.out.printf("%s is now fed.\n", name);
            return true;
        }
        System.out.printf("%s is still hungry.\n", name);
        return false;
    }

    /**
     * Prints the name of the cat and whether it's fed or hungry
     */
    public void info() {
        System.out.printf("%s is %s.\n", name, isFed ? "fed" : "hungry");
    }

}
