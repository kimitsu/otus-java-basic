package ru.otus.java.basic.hw5.training;

public class ConditionalUtilsCountInner {

    public static int countInnerNumber(int base, int checkNumber) {
        String baseString = "" + base;
        String numberString = "" + checkNumber;
        int count = 0;
        int startIndex = 0;
        while (true) {
            int i = baseString.indexOf(numberString, startIndex);
            if (i == -1) {
                return count;
            }
            count++;
            startIndex = i + 1;
        }
    }

    private ConditionalUtilsCountInner() {

    }

    public static void main(String[] args) {
        System.out.println("При вводе чисел 6522 и 22 метод должен вернуть 1 - "
                + ConditionalUtilsCountInner.countInnerNumber(2222, 22));
    }
}