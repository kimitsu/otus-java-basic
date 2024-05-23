package ru.otus.java.basic.hw7.transport;

public class OffRoadVehicle extends MotorVehicle {
    /**
     * Create an off-road vehicle
     *
     * @param model           name of the model of the vehicle
     * @param fuelCapacity    fuel tank capacity, non-negative
     * @param fuelAmount      current fuel amount, non-negative
     * @param fuelPerDistance units of fuel consumed per fuel of distance on normal terrain, non-negative
     */
    public OffRoadVehicle(String model, double fuelCapacity, double fuelAmount, double fuelPerDistance) {
        super(model, fuelCapacity, fuelAmount, fuelPerDistance);
    }

}
