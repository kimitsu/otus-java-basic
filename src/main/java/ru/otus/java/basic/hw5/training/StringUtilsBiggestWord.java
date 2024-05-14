package ru.otus.java.basic.hw5.training;

public class StringUtilsBiggestWord {
    public static String getLargest(String input) {
        String cleanInput = input.replaceAll("(?U)([^\\w ]|[_\\d])", "");
        int wordStart = 0;
        int maxLength = 0;
        String maxWord = "";
        for (int i = 0; i <= cleanInput.length(); i++) {
            if (i == cleanInput.length() || cleanInput.charAt(i) == ' ') {
                if (wordStart < i) {
                    if (i - wordStart >= maxLength) {
                        maxWord = cleanInput.substring(wordStart, i);
                        maxLength = i - wordStart;
                    }
                }
                wordStart = i + 1;
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        System.out.println("asdfПри вводе строки \"самое бол@@ьёшое слово\" метод должен вернуть \"бол@@ьшое\" - "
                + StringUtilsBiggestWord.getLargest("самое бол@@ёь21341_2шое сл123о__@@@@@во"));
    }
}