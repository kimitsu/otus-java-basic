package ru.otus.java.basic.hw11.searchtree;

import java.util.List;

public interface SearchTree<T> {
    /**
     * @param element to find
     * @return element if exists, otherwise - null
     */
    T find(T element);

    /**
     * @return list of elements, sorted in the ascending order
     */
    List<T> getSortedList();
}
