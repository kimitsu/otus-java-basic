package ru.otus.java.basic.hw8.training;

public class FunctionUtilsConvertNumToHex {
    private static final String[] digits =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static String convertNumToHex(int input) {
        int number = input > 0 ? input : -input;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(digits[number & 0xF]);
            number >>= 4;
        } while (number != 0);
        if (input < 0) {
            stringBuilder.append("-");
        }
        return stringBuilder.reverse().toString();
    }

    private FunctionUtilsConvertNumToHex() {
    }

    public static void main(String[] args) {
        System.out.println("При вводе числа 8191, метод должен вернуть 1FFF - '" + FunctionUtilsConvertNumToHex.convertNumToHex(-4095) + "'");
    }
}
