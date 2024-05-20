package ru.otus.java.basic.hw7.transport;

public interface Rideable extends Named {
    /**
     * Notify rideable of a rider mounting, or dismounting it
     *
     * @param rider rider, which mounted the rideable
     *              null, if the rideable is dismounted
     */
    default void setRider(Rider rider) {
    }

    /**
     * Get the current rider of the rideable
     *
     * @return current rider of a rideable,
     * null if there is no rider, or if the method is not implemented
     */
    default Rider getRider() {
        return null;
    }
}
