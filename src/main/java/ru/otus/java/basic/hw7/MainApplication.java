package ru.otus.java.basic.hw7;

import ru.otus.java.basic.hw7.transport.*;

import java.util.Random;

public class MainApplication {
    /**
     * Attempt to traverse various terrain on various vehicles randomly for a few iterations
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Human[] racers = {
                new Human("Fernando", 100.0, 100.0, 1.0),
                new Human("Michael", 100.0, 100.0, 1.0),
        };
        Transport[] transports = {
                new Car("BMW", 100.0, 100.0, 0.2),
                new Horse("Roach", 100.0, 100.0, 0.5),
                new Bicycle(0.8),
                new OffRoadVehicle("UAZ", 80.0, 80.0, 0.6),
                null
        };
        Terrain[] terrains = Terrain.values();
        Random rng = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println();
            Transport transport = transports[rng.nextInt(transports.length)];
            Human racer = racers[rng.nextInt(racers.length)];
            Terrain terrain = terrains[rng.nextInt(terrains.length)];
            if (transport != null) {
                racer.mount(transport);
            }
            racer.travel(rng.nextDouble(50.0), terrain);
            if (transport != null) {
                racer.dismount();
            }
        }
    }
}
