package ru.otus.java.basic.hw7.transport;

public class Bicycle implements Transport {
    Rider currentRider;
    private final double endurancePerDistance;

    /**
     * Create a bicycle
     *
     * @param endurancePerDistance units of stress per unit of distance exerted on the rider on normal terrain
     */
    public Bicycle(double endurancePerDistance) {
        if (endurancePerDistance < 0 || !Double.isFinite(endurancePerDistance)) {
            throw new IllegalArgumentException("Illegal endurancePerDistance");
        }
        this.endurancePerDistance = endurancePerDistance;
    }

    /**
     * Travel for certain distance over certain terrain, except swamp, exerting stress on the rider
     *
     * @param distance distance to travel
     * @param terrain  terrain to travel over
     * @return true if the travel is successful,
     * false if the travel is cancelled due to rider unable to handle the stress, or due to impassable terrain
     * @throws IllegalStateException if there is no one riding the bicycle
     */
    @Override
    public boolean travel(double distance, Terrain terrain) {
        if (Utils.isIllegal(distance)) {
            throw new IllegalArgumentException("Illegal distance");
        }
        if (currentRider == null) {
            throw new IllegalStateException("Someone must ride the bicycle for it to travel");
        }
        if (terrain == Terrain.SWAMP) {
            System.out.printf("Bicycle can't travel through %s, so the trip is canceled.%n", terrain.getName());
            return false;
        }
        double exertedStress = distance * terrain.getDifficulty() * endurancePerDistance;
        System.out.printf("%s travels on a bicycle through the %s for %f units of distance," +
                        " which exerts %f units of stress on the rider.%n",
                currentRider.getName(), terrain.getName(), distance, exertedStress);
        return currentRider.exertStress(exertedStress);
    }

    /**
     * Set the rider of the bicycle
     *
     * @param rider rider, which mounted the rideable
     *              null, if the rideable is dismounted
     */
    @Override
    public void setRider(Rider rider) {
        currentRider = rider;
    }

    /**
     * Get the bicycle's rider
     *
     * @return rider of the bicycle
     */
    @Override
    public Rider getRider() {
        return currentRider;
    }

    /**
     * Get name of the bicycle
     *
     * @return "Bicycle"
     */
    @Override
    public String getName() {
        return "Bicycle";
    }
}
