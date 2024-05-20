package ru.otus.java.basic.hw7.transport;

public interface Rider extends Named {

    /**
     * Mount a transport
     *
     * @param transport transport to mount
     * @throws IllegalStateException if the rider is already riding a transport
     */
    void mount(Transport transport);

    /**
     * Dismount a transport
     *
     * @throws IllegalStateException if the rider is not currently riding a transport
     */
    void dismount();

    /**
     * Exert stress on the rider
     *
     * @param amount amount in units of stress
     * @return true if the rider successfully endures the stress,
     * false if the rider can't handle the stress and the action is canceled
     */
    boolean exertStress(double amount);
}
