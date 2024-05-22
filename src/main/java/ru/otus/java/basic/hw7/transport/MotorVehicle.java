package ru.otus.java.basic.hw7.transport;

public abstract class MotorVehicle implements Transport {
    private final String model;
    private final double fuelCapacity;
    private double fuelAmount;
    private final double fuelPerDistance;

    /**
     * Create a motor vehicle
     *
     * @param model           name of the model of the vehicle
     * @param fuelCapacity    fuel tank capacity
     * @param fuelAmount      current fuel amount
     * @param fuelPerDistance units of fuel consumed per unit of distance on normal terrain
     */
    public MotorVehicle(String model, double fuelCapacity, double fuelAmount, double fuelPerDistance) {
        if (model == null) {
            throw new IllegalArgumentException("Illegal model");
        }
        if (fuelCapacity < 0 || !Double.isFinite(fuelCapacity)) {
            throw new IllegalArgumentException("Illegal fuelCapacity");
        }
        if (fuelAmount < 0 || !Double.isFinite(fuelAmount)) {
            throw new IllegalArgumentException("Illegal fuelAmount");
        }
        if (fuelPerDistance < 0 || !Double.isFinite(fuelPerDistance)) {
            throw new IllegalArgumentException("Illegal fuelPerDistance");
        }
        this.model = model;
        this.fuelCapacity = fuelCapacity;
        this.fuelAmount = fuelAmount;
        this.fuelPerDistance = fuelPerDistance;
    }

    /**
     * Add fuel to the fuel tank, if there is enough space
     *
     * @param amount amount of fuel to add to the tank
     * @return true if successful, false if there is not enough space in the tank
     */
    public boolean addFuel(double amount) {
        if (Utils.isIllegal(amount)) {
            throw new IllegalArgumentException("Illegal amount");
        }
        if (fuelAmount + amount > fuelCapacity) {
            System.out.printf("%s can't be fueled with %f units of fuel," +
                    " there's not enough space in the fuel tank.%n", model, amount);
            return false;
        }
        fuelAmount += amount;
        System.out.printf("%s is refueled with %f units of fuel, there is now %f units in the fuel tank.%n",
                model, amount, fuelAmount);
        return true;
    }

    /**
     * Travel for certain distance over certain terrain, expending fuel
     *
     * @param distance distance to travel
     * @param terrain  terrain to travel over
     * @return true if the travel is successful, false if the travel is cancelled due to insufficient fuel
     */
    @Override
    public boolean travel(double distance, Terrain terrain) {
        if (terrain == null) {
            throw new IllegalArgumentException("Illegal terrain");
        }
        if (distance < 0 || !Double.isFinite(distance)) {
            throw new IllegalArgumentException("Illegal distance");
        }
        System.out.printf("%s travels through the %s for %f units of distance.%n", model, terrain.getName(), distance);
        double fuelRequired = distance * terrain.getDifficulty() * fuelPerDistance;
        if (fuelRequired > fuelAmount) {
            System.out.printf("%s has insufficient fuel, so the trip is canceled.%n", model);
            return false;
        }
        fuelAmount -= fuelRequired;
        System.out.printf("%s expends %f units of fuel and is left with %f units.%n", model, fuelRequired, fuelAmount);
        return true;
    }

    /**
     * Get the name of the model
     *
     * @return name of the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Get the name of the model
     *
     * @return name of the model
     */
    @Override
    public String getName() {
        return getModel();
    }
}
