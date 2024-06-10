package ru.otus.java.basic.hw11.training;

import java.util.HashMap;
import java.util.Map;

public class CollectionUtilsCount {
    public static <K> Map<K, Integer> countElements(K[] inputArray) {
        Map<K, Integer> result = new HashMap<>();
        for (K item : inputArray) {
            result.put(item, result.getOrDefault(item, 0) + 1);
        }
        return result;
    }

    private CollectionUtilsCount() {

    }

    public static void main(String[] args) {
        System.out.println("При вводе массива [1, 2, 4, 1, 1, 1, 2, 3, 2], метод должен вернуть [\"1\", 4, \"2\", 3, \"4\", 1, \"3\", 1] - "
                + CollectionUtilsCount.countElements(new String[]{"1", "2", "4", "1", "1", "1", "2", "3", "2"}));
    }
}