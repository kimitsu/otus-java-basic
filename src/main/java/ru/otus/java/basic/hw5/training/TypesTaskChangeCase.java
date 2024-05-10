package ru.otus.java.basic.hw5.training;

public class TypesTaskChangeCase {
    public static char changeCase(char input) {
        return Character.isLowerCase(input) ? Character.toUpperCase(input) : Character.toLowerCase(input);
    }

    public static void main(String[] args) {
        System.out.println(
                "Ввод G в верхнем регистре, должны получить в нижнем: " +
                        changeCase('G')
        );
        System.out.println(
                "Ввод g в нижнем регистре, должны получить в верхнем: " +
                        changeCase('g')
        );
    }
}