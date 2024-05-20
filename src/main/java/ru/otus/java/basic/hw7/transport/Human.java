package ru.otus.java.basic.hw7.transport;

import ru.otus.java.basic.hw7.transport.*;

public class Human extends Animal implements Rider {
    private Transport currentTransport;

    public Human(String name, double enduranceCapacity, double enduranceAmount, double endurancePerDistance) {
        super(name, enduranceCapacity, enduranceAmount, endurancePerDistance);
        this.currentTransport = null;
    }

    public void mount(Transport transport) {
        if (transport == null) {
            throw new IllegalArgumentException("Illegal transport");
        }
        if (currentTransport != null) {
            throw new IllegalStateException("Already riding a transport");
        }
        currentTransport = transport;
        currentTransport.setRider(this);
        System.out.printf("%s is now riding %s.\n", getName(), currentTransport.getName());
    }

    public void dismount() {
        if (currentTransport == null) {
            throw new IllegalStateException("Currently not riding a transport");
        }
        currentTransport.setRider(null);
        currentTransport = null;
        System.out.printf("%s has dismounted its transport.\n", getName());
    }

    public boolean travel(double distance, Terrain terrain) {
        if (currentTransport != null) {
            System.out.printf("%s travels on a %s.\n", getName(), currentTransport.getName());
            return currentTransport.travel(distance, terrain);
        }
        System.out.printf("%s travels on foot.\n", getName());
        return super.travel(distance, terrain);
    }
}
