package ru.otus.java.basic.hw7.transport;

public class Horse extends Animal implements Transport {
    /**
     * Create a horse
     *
     * @param name                 name of the horse
     * @param enduranceCapacity    units of stress that the horse can endure from its fully rested condition
     * @param enduranceAmount      units of stress that tha horse may endure before it exhausts itself
     * @param endurancePerDistance units of stress expended per unit of distance of travel
     */
    public Horse(String name, double enduranceCapacity, double enduranceAmount, double endurancePerDistance) {
        super(name, enduranceCapacity, enduranceAmount, endurancePerDistance);
    }

    /**
     * Travel for certain distance over certain terrain, except swamp, exerting stress
     *
     * @param distance distance to travel
     * @param terrain  terrain to travel over
     * @return true if the travel is successful,
     * false if the travel is cancelled due to insufficient endurance or impassable terrain
     */
    @Override
    public boolean travel(double distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.printf("%s can't travel through %s, so the trip is canceled.%n", getName(), terrain.getName());
            return false;
        }
        return super.travel(distance, terrain);
    }
}
