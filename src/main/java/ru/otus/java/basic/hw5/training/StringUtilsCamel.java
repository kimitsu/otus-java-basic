package ru.otus.java.basic.hw5.training;

public class StringUtilsCamel {
    public static String toCamelCase(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        boolean isNewWord = false;
        boolean isFirstWord = true;
        for (char character : chars) {
            if (character == ' ') {
                isNewWord = !isFirstWord;
            } else if (character >= 'a' && character <= 'z') {
                if (isNewWord) {
                    result.append(("" + character).toUpperCase());
                    isNewWord = false;
                } else {
                    result.append(character);
                    isFirstWord = false;
                }
            } else if (character >= 'A' && character <= 'Z') {
                if (isNewWord) {
                    result.append(character);
                    isNewWord = false;
                } else {
                    result.append(("" + character).toLowerCase());
                    isFirstWord = false;
                }
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println("Строка \"my camel * case string 1\" должна преобразоваться в myCamelCaseString - "
                + StringUtilsCamel.toCamelCase("my camel * case string 1"));
    }
}