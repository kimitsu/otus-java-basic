package ru.otus.java.basic.hw7.transport;

public interface Traveller {
    /**
     * Travel for certain distance over certain terrain
     *
     * @param distance distance to travel
     * @param terrain terrain to travel over
     * @return true if the travel is successful, false if the travel is cancelled
     */
    boolean travel(double distance, Terrain terrain);
}
