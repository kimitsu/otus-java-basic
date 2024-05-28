package ru.otus.java.basic.hw10.phonebook;

import ru.otus.java.basic.hw10.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private final Map<String, Set<String>> entries = new HashMap<>();

    /**
     * Adds or modifies an entry with the specified name, adding the specified phone to the entry
     * The phone will not be added if it is already present
     *
     * @param name  name of the entry
     * @param phone phone to add to the entry
     */
    public void add(String name, String phone) {
        Utils.validateNotNull(name, "name");
        Utils.validateNotNull(phone, "phone");
        Set<String> entry = entries.get(name);
        if (entry == null) {
            entry = new HashSet<>();
        }
        entry.add(phone);
        entries.put(name, entry);
    }


    /**
     * Finds an entry with the specified name
     *
     * @param name name of the entry to find
     * @return a set of phones in the entry, or null if the entry is not found
     */
    public Set<String> find(String name) {
        Utils.validateNotNull(name, "name");
        return entries.get(name);
    }

    /**
     * Check if a phone number is present in one of the entries
     *
     * @param phone phone to lookup
     * @return true if the phone is found in one of the entries, false otherwise
     */
    public boolean containsPhoneNumber(String phone) {
        Utils.validateNotNull(phone, "phone");
        return entries
                .values()
                .stream()
                .anyMatch(entry -> entry.contains(phone));
    }
}
