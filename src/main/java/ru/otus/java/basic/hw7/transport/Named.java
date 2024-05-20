package ru.otus.java.basic.hw7.transport;

public interface Named {
    /**
     * Get name of the named object
     *
     * @return name of the named,
     * or "Unnamed" if the method is not implemented
     */
    default String getName() {
        return "Unnamed";
    }
}
