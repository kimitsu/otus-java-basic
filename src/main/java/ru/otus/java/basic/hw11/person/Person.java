package ru.otus.java.basic.hw11.person;

import ru.otus.java.basic.hw11.Utils;

import java.util.Objects;

public class Person {
    private final Long id;
    private String name;
    private Position position;

    /**
     * @param id       a unique id of the person
     * @param name     name of the person
     * @param position position of the person
     */
    public Person(Long id, String name, Position position) {
        Utils.validateNotNull(id, "id");
        Utils.validateNotNull(name, "name");
        Utils.validateNotNull(position, "position");
        this.id = id;
        this.name = name;
        this.position = position;
    }

    /**
     * @return true if in management-related position
     */
    public boolean isManager() {
        return position.isManager();
    }

    /**
     * @return hash code based on id
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @return person's id
     */
    public Long getId() {
        return id;
    }
}
