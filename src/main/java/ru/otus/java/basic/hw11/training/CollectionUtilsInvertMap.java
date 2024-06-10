package ru.otus.java.basic.hw11.training;

import java.util.*;

public class CollectionUtilsInvertMap {
    public static <K, V> Map<V, K> invertMap(Map<? extends K, ? extends V> inputMap) {
        HashMap<V, K> result = new HashMap<>();
        for (K key : inputMap.keySet()) {
            result.put(inputMap.get(key), key);
        }
        return result;
    }

    private CollectionUtilsInvertMap() {

    }

    public static void main(String[] args) {
        System.out.println("При вводе Map {1=a, 2=b, 3=c} метод должен вернуть {a=1, b=2, c=3} - '"
                + CollectionUtilsInvertMap.invertMap(Map.of(1, "a", 2, "b", 3, "c")) + "'");
    }
}