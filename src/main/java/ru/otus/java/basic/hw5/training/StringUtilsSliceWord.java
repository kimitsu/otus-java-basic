package ru.otus.java.basic.hw5.training;

public class StringUtilsSliceWord {
    public static String getSlice(String input, int leftEdge, int rightEdge) {
        if (rightEdge < leftEdge || rightEdge < 0 || leftEdge < 0) {
            return input;
        }
        return input.substring(leftEdge, rightEdge >= input.length() ? input.length() : rightEdge + 1);
    }

    public static void main(String[] args) {
        System.out.println("При вводе строки \"Test\" с индексами 1 и 4 метод должен вернуть \"est\" - "
                + "\"" + StringUtilsSliceWord.getSlice("Test", 1,4) +"\"");

    }
}