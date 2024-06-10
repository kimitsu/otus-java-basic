package ru.otus.java.basic.hw13.training;

import java.util.ArrayList;
import java.util.Arrays;

public class ExceptionTaskGetAllElements {
    private static String processString(String item) {
        if(item.contains("Ю")) {
            throw new IllegalArgumentException("Обнаружена буква Ю!");
        }
        if(item.contains("Ё")) {
            throw new NullPointerException("Ё не разрешено!");
        }
        return item;
    }

    public static String[] getAllElements(String[] input) {
        var result = new ArrayList<String>(input.length);
        for (String item : input) {
            try {
                result.add(processString(item));
            } catch (Exception e) {
                result.add(e.getMessage());
            } finally {
                result.add("end");
            }
        }
        return result.toArray(new String[0]);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAllElements(new String[]{"Ю", "б", "в", "Ю", "Д", "ЁЖ"})));
    }
}