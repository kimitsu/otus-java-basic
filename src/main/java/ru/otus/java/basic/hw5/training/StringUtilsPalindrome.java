package ru.otus.java.basic.hw5.training;

public class StringUtilsPalindrome {
    public static boolean isPalindrome(String input) {
        String lower = input.toLowerCase();
        boolean empty = true;
        int i = 0;
        int j = input.length() - 1;
        while (i <= j) {
            char ci = lower.charAt(i);
            if (!((ci >= 'a' && ci <= 'z') || (ci >= 'а' && ci <= 'я'))) {
                i++;
                continue;
            }
            char cj = lower.charAt(j);
            if (!((cj >= 'a' && cj <= 'z') || (cj >= 'а' && cj <= 'я'))) {
                j--;
                continue;
            }
            if (ci != cj) {
                return false;
            }
            empty = false;
            i++;
            j--;
        }
        return !empty;
    }

    public static void main(String[] args) {
        System.out.println("При вводе строки \"шалаш\" метод должен вернуть true - " + StringUtilsPalindrome.isPalindrome("шалаш"));
    }
}
