package ru.otus.java.basic.hw11.searchtree;

import ru.otus.java.basic.hw11.Utils;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree<T extends Comparable<T>> implements SearchTree<T> {

    private RedBlackNode<T> node = null;

    /**
     * Creates an empty tree
     */
    public RedBlackTree() {
    }

    /**
     * @param list a list to convert into a tree
     */
    public RedBlackTree(List<T> list) {
        Utils.validateNotNull(list, "list");
        for (T element : list) {
            add(element);
        }
    }

    /**
     * @param element an element to add to the tree
     */
    public void add(T element) {
        Utils.validateNotNull(element, "element");

        RedBlackNode<T> currentNode = this.node;
        // Binary search the tree to find a place for the new node, remember the route
        int currentBranch = RedBlackNode.ROOT;
        List<RedBlackNode<T>> parents = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        while (currentNode != null) {
            parents.add(currentNode);
            route.add(currentBranch);
            currentBranch = element.compareTo(currentNode.value) > 0 ? RedBlackNode.RIGHT : RedBlackNode.LEFT;
            currentNode = currentNode.branches[currentBranch];
        }
        // Create the new node (red)
        currentNode = new RedBlackNode<>(element);

        while (true) {
            if (currentBranch == RedBlackNode.ROOT) {
                // Set root to the current node
                node = currentNode;
                node.isRed = false;
                return;
            } else {
                // Assign the current node to the parent's branch
                parents.getLast().branches[currentBranch] = currentNode;
            }

            RedBlackNode<T> parentNode = parents.removeLast();
            int parentBranch = route.removeLast();

            if (!currentNode.isRed || !parentNode.isRed) {
                return;
            }

            // If the current and parent node are red, the no-red-red rule is violated
            assert !parents.isEmpty(); // root node can't be red
            RedBlackNode<T> grandParentNode = parents.removeLast();
            int grandParentBranch = route.removeLast();
            RedBlackNode<T> uncleNode = grandParentNode.branches[1 - parentBranch];
            if (uncleNode != null && uncleNode.isRed) {
                /*
                    Case 1. Parent and uncle of the inserted node is red.
                    Recolor both to black, and paint grandparent red.
                    Proceed to grandparent.
                 */
                uncleNode.isRed = false;
                parentNode.isRed = false;
                grandParentNode.isRed = true;
                currentNode = grandParentNode;
                currentBranch = grandParentBranch;
            } else {
                /*
                    Case 2. Parent is red, uncle is black.
                    Step 1. If the inserted node is an inner child,
                            rotate it into parent to make the parent an outer child.
                 */
                if (currentBranch != parentBranch) {
                    grandParentNode.branches[parentBranch] = currentNode;
                    parentNode.branches[currentBranch] = currentNode.branches[1 - currentBranch];
                    currentNode.branches[1 - currentBranch] = parentNode;
                    parentNode = currentNode;
                    currentBranch = 1 - currentBranch;
                    currentNode = parentNode.branches[currentBranch];
                }
                /*
                    Step 2. Rotate the parent into grandparent.
                            Recolor the parent to black, old grandparent (new uncle) to red.

                 */
                grandParentNode.branches[parentBranch] = parentNode.branches[1 - currentBranch];
                parentNode.branches[1 - currentBranch] = grandParentNode;
                grandParentNode.isRed = true;
                parentNode.isRed = false;
                currentNode = parentNode;
                currentBranch = grandParentBranch;
            }
        }
    }

    /**
     *
     * @param element an element to find
     * @return the first found element that is equal (by means of .compareTo(...) == 0) to the specified element,
     * null if not found
     */
    @Override
    public T find(T element) {
        Utils.validateNotNull(element, "element");
        return node == null ? null : node.find(element);
    }

    /**
     * @return list of the elements contained in the tree sorted in the ascending order
     */
    @Override
    public List<T> getSortedList() {
        return node == null ? new ArrayList<T>() : node.getSortedList();
    }

    /**
     * @return string representation of the tree structure for debug purposes
     */
    @Override
    public String toString() {
        return super.toString() + (node == null ? "" : node.toString());
    }
}
