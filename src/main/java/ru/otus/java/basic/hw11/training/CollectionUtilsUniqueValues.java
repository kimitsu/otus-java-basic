package ru.otus.java.basic.hw11.training;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionUtilsUniqueValues {
    public static <T> Collection<T> removeDuplicates(Collection<T> inputCollection) {
        return new HashSet<T>(inputCollection).stream().toList();
    }

    private CollectionUtilsUniqueValues() {

    }

    public static void main(String[] args) {
        System.out.println("При вводе коллекции (1, 2, 3, 3, 2, 4) метод должен вернуть (1, 2, 3, 4) - "
                + CollectionUtilsUniqueValues.removeDuplicates(List.of(1, 2, 3, 3, 2, 4)));
    }
}