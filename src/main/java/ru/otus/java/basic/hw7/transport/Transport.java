package ru.otus.java.basic.hw7.transport;

public interface Transport {
    /**
     * Notify transport of a rider mounting, or dismounting it
     *
     * @param rider rider, which mounted the rideable
     *              null, if the rideable is dismounted
     */
    default void setRider(Rider rider) {
    }

    /**
     * Get the current rider of the transport
     *
     * @return current rider of a transport,
     * null if there is no rider, or if the method is not implemented
     */
    default Rider getRider() {
        return null;
    }

    /**
     * Travel for a certain distance over certain terrain
     *
     * @param distance distance to travel
     * @param terrain  terrain to travel over
     * @return true if the travel is successful, false if the travel is cancelled
     */
    default boolean travel(double distance, Terrain terrain) {
        return false;
    }

    /**
     * Get the name of the transport
     *
     * @return name of the transport,
     * or "Unnamed" if the method is not implemented
     */
    default String getName() {
        return "Unnamed";
    }
}
