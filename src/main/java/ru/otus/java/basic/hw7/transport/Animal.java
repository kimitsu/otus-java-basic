package ru.otus.java.basic.hw7.transport;

public class Animal implements Transport {
    private final String name;
    private final double enduranceCapacity;
    private double enduranceAmount;
    private final double endurancePerDistance;

    /**
     * Create an animal
     *
     * @param name                 name of the animal
     * @param enduranceCapacity    units of stress that the animal can endure from its fully rested condition
     * @param enduranceAmount      units of stress that tha animal may endure before it exhausts itself
     * @param endurancePerDistance units of stress expended per unit of distance of travel
     */
    public Animal(String name, double enduranceCapacity, double enduranceAmount, double endurancePerDistance) {
        if (name == null) {
            throw new IllegalArgumentException("Illegal name");
        }
        if (Utils.isIllegal(enduranceCapacity)) {
            throw new IllegalArgumentException("Illegal enduranceCapacity");
        }
        if (Utils.isIllegal(enduranceAmount)) {
            throw new IllegalArgumentException("Illegal enduranceAmount");
        }
        if (Utils.isIllegal(endurancePerDistance)) {
            throw new IllegalArgumentException("Illegal endurancePerDistance");
        }
        this.name = name;
        this.enduranceCapacity = enduranceCapacity;
        this.enduranceAmount = enduranceAmount;
        this.endurancePerDistance = endurancePerDistance;
    }

    /**
     * Rest and recover animal's endurance to its full
     */
    public void rest() {
        enduranceAmount = enduranceCapacity;
        System.out.printf("%s have rested, their endurance recovered up to %f.%n", name, enduranceAmount);
    }

    /**
     * Travel for certain distance over certain terrain, exerting stress
     *
     * @param distance distance to travel
     * @param terrain  terrain to travel over
     * @return true if the travel is successful, false if the travel is cancelled due to insufficient endurance
     */
    @Override
    public boolean travel(double distance, Terrain terrain) {
        if (terrain == null) {
            throw new IllegalArgumentException("Illegal terrain");
        }
        if (Utils.isIllegal(distance)) {
            throw new IllegalArgumentException("Illegal distance");
        }
        double enduranceRequired = distance * terrain.getDifficulty() * endurancePerDistance;
        System.out.printf("%s travels through the %s for %f units of distance.%n", name, terrain.getName(), distance);
        return exertStress(enduranceRequired);
    }

    /**
     * Exert stress, if the animal can endure it
     *
     * @param amount amount of stress to exert
     * @return true if the animal successfully exerts stress
     * false if the animal doesn't have enough endurance
     */
    public boolean exertStress(double amount) {
        if (Utils.isIllegal(amount)) {
            throw new IllegalArgumentException("Illegal amount");
        }
        if (amount > enduranceAmount) {
            System.out.printf("%s can't exert such stress, so the trip is cancelled.%n", name);
            return false;
        }
        enduranceAmount -= amount;
        System.out.printf("%s exerts %f units of stress and is left with %f units of endurance.%n", name, amount, enduranceAmount);
        return true;
    }

    /**
     * Get the animal's name
     *
     * @return animal's name
     */
    @Override
    public String getName() {
        return name;
    }
}
