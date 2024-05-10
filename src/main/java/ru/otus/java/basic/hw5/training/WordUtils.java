package ru.otus.java.basic.hw5.training;

import java.util.Arrays;

public class WordUtils {
    public static String reverseWords(String inputText) {
        String[] words = inputText.split(" ");
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = words[words.length - i - 1];
        }
        return String.join(" ", reversedWords);
    }

    public static void main(String[] args) {
        System.out.println("Ввод пустой строки - " + WordUtils.reverseWords(""));
        System.out.println("Ввод одного слова - " + WordUtils.reverseWords("word"));
        System.out.println("Ввод двух слов - " + WordUtils.reverseWords("два слова"));
    }
}
