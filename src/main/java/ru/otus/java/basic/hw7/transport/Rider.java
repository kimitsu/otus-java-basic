package ru.otus.java.basic.hw7.transport;

public interface Rider {

    /**
     * Mount a transport
     *
     * @param transport transport to mount
     * @throws IllegalStateException if the rider is already riding a transport
     */
    default void mount(Transport transport) {
    }

    /**
     * Dismount a transport
     *
     * @throws IllegalStateException if the rider is not currently riding a transport
     */
    default void dismount() {
    }

    /**
     * Exert stress on the rider
     *
     * @param amount amount in units of stress
     * @return true if the rider successfully endures the stress or if the method is not implemented,
     * false if the rider can't handle the stress and the action is canceled
     */
    default boolean exertStress(double amount) {
        return true;
    }

    /**
     * Get the name of the rider
     *
     * @return name of the rider,
     * or "Unnamed" if the method is not implemented
     */
    default String getName() {
        return "Unnamed";
    }
}
