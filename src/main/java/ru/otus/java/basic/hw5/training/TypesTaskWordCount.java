package ru.otus.java.basic.hw5.training;

public class TypesTaskWordCount {
    public static int wordCount(String input) {
        int count = 0;
        boolean newWord = true;
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (Character.isSpaceChar(inputChar)) {
                newWord = true;
            } else {
                if (newWord) {
                    newWord = false;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                "В этой строке пять слов: " +
                        wordCount("В этой строке пять слов: ")
        );
    }
}