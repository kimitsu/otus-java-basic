package ru.otus.java.basic.hw11.training;

import java.util.LinkedList;
import java.util.List;

public class SimpleStackTest {
    private SimpleStackTest() {
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new SimpleStack();
        System.out.println("Вначале стек пуст: " + stack.isEmpty());
        System.out.println("Помещаем в стек 42: " + stack.push(42));
        System.out.println("После добавления элемента - не пуст: " + stack.isEmpty());
        System.out.println("Достали из стека последнее значение: " + stack.pop());
        System.out.println("После удаления элемента стек снова пуст: " + stack.isEmpty());
    }
}

interface Stack<T> {
    T push(T item);

    T pop();

    boolean isEmpty();
}

class SimpleStack implements Stack<Integer> {
    private final List<Integer> list = new LinkedList<Integer>();

    @Override
    public Integer push(Integer item) {
        list.add(item);
        return item;
    }

    @Override
    public Integer pop() {
        return list.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}