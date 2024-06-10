package ru.otus.java.basic.hw11.training;

import java.util.Iterator;
import java.util.List;

public class CollectionUtilsElementComparison {
    public static boolean isValuesMatch(List<?> leftList, List<?> rightList) {
        Iterator<?> iterator = leftList.iterator();
        while (iterator.hasNext()) {
            if (!rightList.contains(iterator.next())) {
                return false;
            }
        }
        iterator = rightList.iterator();
        while (iterator.hasNext()) {
            if (!leftList.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    private CollectionUtilsElementComparison() {

    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе массивов: (1, 2, 3) и (4, 5, 6), метод должен вернуть false - '"
                        + CollectionUtilsElementComparison.isValuesMatch(List.of(1, 2, 3), List.of(4, 5, 6))
                        + "'"
        );
    }
}