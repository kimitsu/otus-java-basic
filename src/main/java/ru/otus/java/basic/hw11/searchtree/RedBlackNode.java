package ru.otus.java.basic.hw11.searchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * Internal helper class that represents nodes of a red-black tree
 *
 * @param <T> type of elements to store in the tree, must be Comparable
 */
class RedBlackNode<T extends Comparable<T>> {
    static final int ROOT = -1;
    static final int LEFT = 0;
    static final int RIGHT = 1;
    RedBlackNode<T>[] branches;
    boolean isRed = true;
    T value;

    /**
     * @param element element to find
     * @return first element to be found to be equal (by means of .compareTo(...) == 0) to the specified element
     */
    T find(T element) {
        if (element == null) {
            return null;
        }
        int comparison = element.compareTo(value);
        if (comparison == 0) {
            return value;
        }
        if (comparison < 0 && branches[LEFT] != null) {
            return branches[LEFT].find(element);
        }
        if (branches[RIGHT] != null) {
            return branches[RIGHT].find(element);
        }
        return null;
    }

    /**
     * @return sorted list of the elements that are contained in the tree
     */
    List<T> getSortedList() {
        List<T> result = branches[LEFT] != null ? branches[LEFT].getSortedList() : new ArrayList<>();
        result.add(value);
        if (branches[RIGHT] != null) {
            result.addAll(branches[RIGHT].getSortedList());
        }
        return result;
    }

    /**
     * Creates a red node with a specified value
     *
     * @param value a value to store in the node
     */
    RedBlackNode(T value) {
        this.branches = new RedBlackNode[]{null, null};
        this.value = value;
    }

    /**
     * @return a string representation of the tree contents useful for debugging
     */
    @Override
    public String toString() {
        String result = "(" + (branches[LEFT] == null ? "" : branches[LEFT]);
        if (isRed) {
            result += "`" + value + "`";
        } else {
            result += " " + value + " ";
        }
        result += branches[RIGHT] == null ? "" : branches[RIGHT];
        return result + ")";
    }
}
