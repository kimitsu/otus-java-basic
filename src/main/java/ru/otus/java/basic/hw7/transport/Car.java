package ru.otus.java.basic.hw7.transport;

public class Car extends MotorVehicle {
    /**
     * Create a car
     *
     * @param model           name of the model of the car
     * @param fuelCapacity    fuel tank capacity
     * @param fuelAmount      current fuel amount
     * @param fuelPerDistance units of fuel consumed per fuel of distance on normal terrain
     */
    public Car(String model, double fuelCapacity, double fuelAmount, double fuelPerDistance) {
        super(model, fuelCapacity, fuelAmount, fuelPerDistance);
    }

    /**
     * Travel for certain distance over certain terrain, except forest or swamp, expending fuel
     *
     * @param distance distance to travel
     * @param terrain  terrain to travel over
     * @return if the travel is successful,
     * false if the travel is cancelled due to insufficient fuel or due to impassable terrain
     */
    @Override
    public boolean travel(double distance, Terrain terrain) {
        if (terrain == Terrain.FOREST || terrain == Terrain.SWAMP) {
            System.out.printf("%s can't travel through %s, so the trip is cancelled.%n", getModel(), terrain.getName());
            return false;
        }
        return super.travel(distance, terrain);
    }
}
