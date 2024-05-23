package ru.otus.java.basic.hw7.transport;

public enum Terrain {
    PLAINS("plains", 1.0),
    FOREST("forest", 2.0),
    SWAMP("swamp", 4.0);

    private final String name;
    private final double difficulty;

    Terrain(String name, double difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    /**
     * Get terrain's relative difficulty to traverse
     *
     * @return terrain's relative difficulty
     */
    public double getDifficulty() {
        return difficulty;
    }

    /**
     * Get terrain's name
     *
     * @return terrain's name
     */
    public String getName() {
        return name;
    }
}
