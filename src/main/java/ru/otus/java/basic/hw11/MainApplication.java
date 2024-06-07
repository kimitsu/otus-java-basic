package ru.otus.java.basic.hw11;

import ru.otus.java.basic.hw11.person.Person;
import ru.otus.java.basic.hw11.person.PersonDataBase;
import ru.otus.java.basic.hw11.person.Position;
import ru.otus.java.basic.hw11.searchtree.RedBlackTree;
import ru.otus.java.basic.hw11.searchtree.SearchTree;
import ru.otus.java.basic.hw11.sort.SortUtils;

import java.util.*;

public class MainApplication {
    /**
     * @param size size of the list, and the maximum for the random numbers to generate
     * @return the random list of integers
     */
    public static List<Integer> createRandomList(int size) {
        Random rng = new Random();
        List<Integer> list = new ArrayList<>();
        System.out.println("Creating a list (" + size + " elements)");
        for (int i = 0; i < size; i++) {
            list.add(rng.nextInt(0, size));
        }
        return list;
    }

    /**
     * Various tests
     *
     * @param args unused
     */
    public static void main(String[] args) {
        int listSize = 2_000_000;
        Random rng = new Random();

        List<Integer> list = createRandomList(listSize);
        System.out.print("Creating a red-black tree...");
        long startTime = System.currentTimeMillis();
        SearchTree<Integer> tree = new RedBlackTree<>(list);
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");

        System.out.print("Binary-searching the red-black tree (recursively)...");
        startTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < listSize; i++) {
            count += tree.find(rng.nextInt(0, listSize)) == null ? 0 : 1;
        }
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("Found count = " + count);

        list = createRandomList(listSize);
        startTime = System.currentTimeMillis();
        System.out.print("Sorting the array...");
        list.sort(Comparator.naturalOrder());
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.print("Binary-searching the array...");
        startTime = System.currentTimeMillis();
        count = 0;
        for (int i = 0; i < 1000000; i++) {
            count += Collections.binarySearch(list, rng.nextInt(0, listSize)) < 0 ? 0 : 1;
        }
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("Found count = " + count);

        list = createRandomList(listSize / 100);
        startTime = System.currentTimeMillis();
        System.out.print("Sorting the array using bubbleSort...");
        SortUtils.bubbleSort(list, Comparator.naturalOrder());
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");

        list = createRandomList(listSize);
        System.out.print("Sorting the array using quickSort...");
        startTime = System.currentTimeMillis();
        SortUtils.quickSort(list, Comparator.naturalOrder());
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");

        System.out.print("Creating Person Data Base...");
        startTime = System.currentTimeMillis();
        PersonDataBase personDataBase = new PersonDataBase(Arrays.asList(new Person[]{
                new Person(0L, "Ivanov", Position.DIRECTOR),
                new Person(1L, "Petrov", Position.BRANCH_DIRECTOR),
                new Person(2L, "Sidoroff", Position.DEVELOPER),
        }));
        Position[] positions = Position.values();
        for (int i = 0; i < listSize; i++) {
            personDataBase.add(new Person(rng.nextLong(), "Name" + rng.nextLong(), positions[rng.nextInt(positions.length)]));
        }
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.print("Searching by id...");
        startTime = System.currentTimeMillis();
        count = 0;
        for (int i = 0; i < listSize; i++) {
            if (personDataBase.findById(rng.nextLong()) != null) count += 1;
        }
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("count = " + count);

        System.out.print("Checking if is employee by id...");
        startTime = System.currentTimeMillis();
        count = 0;
        for (int i = 0; i < listSize; i++) {
            if (personDataBase.isEmployee(rng.nextLong())) count += 1;
        }
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("count = " + count);

        System.out.print("Checking if is employee by Person (but it really looks by id)...");
        startTime = System.currentTimeMillis();
        count = 0;
        for (int i = 0; i < listSize; i++) {
            if (personDataBase.isManager(new Person(rng.nextLong(), "Names don't matter", Position.DRIVER))) {
                count += 1;
            }
        }
        System.out.println(" " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("count = " + count);
    }
}