package ru.otus.java.basic.hw9.training;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ObjectsTaskStringToObject {
    private ObjectsTaskStringToObject() {
    }

    public static <T> T makeObjectFromString(String input, T anyObject) {
        for (Constructor<?> constructor : anyObject.getClass().getDeclaredConstructors()) {
            if (constructor.getParameterCount() == 1 && constructor.getParameterTypes()[0] == String.class) {
                try {
                    return (T) constructor.newInstance(input);
                } catch (Exception e) {
                    return null;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("Создаем число из строки: " + makeObjectFromString("15", 1));
        System.out.println("Создаем булево из строки: " + makeObjectFromString("true", true));
        System.out.println("Создаем список из строки, должно не получиться: " + makeObjectFromString("1,2,3", new ArrayList<>()));
    }
}