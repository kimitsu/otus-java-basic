package ru.otus.java.basic.hw9.training;

public class ObjectsTaskClass {
    private ObjectsTaskClass() {
    }

    public static boolean isClaxx(Class claxx, Class clazz) {
        if (claxx == Object.class) {
            return claxx == clazz;
        } else {
            return claxx == clazz || isClaxx(claxx.getSuperclass(), clazz);
        }
    }

    public static boolean isClass(Object object, Class clazz) {
        if (object.getClass() == Object.class) {
            return object.getClass() == clazz;
        } else {
            return object.getClass() == clazz || isClaxx(object.getClass().getSuperclass(), clazz);
        }
    }

    public static void main(String[] args) {
        System.out.println("Строка это класс String: " + isClass("я строка", String.class));
        System.out.println("Число это класс String: " + isClass(42, String.class));
        System.out.println("В Java всё есть объект: " + isClass(42, Object.class));
        System.out.println("В Java всё есть объект: " + isClass("и даже строка", Object.class));
    }
}