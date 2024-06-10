package ru.otus.java.basic.hw11.person;

import ru.otus.java.basic.hw11.Utils;

import java.util.HashMap;
import java.util.List;

public class PersonDataBase {
    private final HashMap<Long, Person> people = new HashMap<>();

    /**
     * Creates empty person database
     */
    public PersonDataBase() {
    }

    /**
     * Creates peron database from a list
     *
     * @param personList a list to add to the database
     */
    public PersonDataBase(List<Person> personList) {
        for (Person person : personList) {
            add(person);
        }
    }

    /**
     * @param person a person to add to the database
     */
    public void add(Person person) {
        Utils.validateNotNull(person, "person");
        people.put(person.getId(), person);
    }

    /**
     * @param id an id of a person to look up the database for
     * @return person with the specified id, or null if not found
     */
    public Person findById(Long id) {
        Utils.validateNotNull(id, "id");
        return people.get(id);
    }

    /**
     * @param person a person whose id to look up the database for
     * @return true if the person is found and is in management position, false otherwise
     */
    public boolean isManager(Person person) {
        Utils.validateNotNull(person, "person");
        Person foundPerson = findById(person.getId());
        return foundPerson != null && foundPerson.isManager();
    }

    /**
     * @param id an id of a person to look up the database for
     * @return true if the person is found and is not in management position, false otherwise
     */
    public boolean isEmployee(Long id) {
        Person foundPerson = findById(id);
        return foundPerson != null && !foundPerson.isManager();
    }
}
