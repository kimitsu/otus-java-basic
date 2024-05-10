package ru.otus.java.basic.hw5.training;

public class StringUtilsCountWord {
    public static int countWord(String input, String word) {
        String preparedInput = " " + input.toLowerCase().replaceAll("(?U)\\W", " ") + " ";
        String preparedWord = " " + word.toLowerCase() + " ";
        int count = 0;
        int startIndex = 0;
        while (true) {
            int i = preparedInput.indexOf(preparedWord, startIndex);
            if (i == -1) return count;
            count++;
            startIndex = i + preparedWord.length();

        }
    }

    public static void main(String[] args) {
        System.out.println("При вводе строки \"Test string for test\" и искомом слове \"test\" метод должен вернуть 2 - "
                + StringUtilsCountWord.countWord("Test string for test", "test"));
    }
}
