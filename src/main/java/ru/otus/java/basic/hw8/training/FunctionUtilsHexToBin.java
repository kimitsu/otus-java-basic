package ru.otus.java.basic.hw8.training;

public class FunctionUtilsHexToBin {

    private static final String[] digits = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    private static final String[] leadingDigits = {"0", "1", "10", "11", "100", "101", "110", "111",
            "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    public static String hexToBin(String hexBase) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isLeading = true;
        for (int i = 0; i < hexBase.length(); i++) {
            char hexDigit = hexBase.charAt(i);
            if (hexDigit == '-') {
                stringBuilder.append('-');
            } else if (hexDigit >= '0' && hexDigit <= '9') {
                stringBuilder.append((isLeading ? leadingDigits : digits)[hexDigit - '0']);
                isLeading = false;
            } else if (hexDigit >= 'A' && hexDigit <= 'F') {
                stringBuilder.append((isLeading ? leadingDigits : digits)[hexDigit - 'A' + 10]);
                isLeading = false;
            } else if (hexDigit >= 'a' && hexDigit <= 'f') {
                stringBuilder.append((isLeading ? leadingDigits : digits)[hexDigit - 'a' + 10]);
                isLeading = false;
            }
        }
        return stringBuilder.toString();
    }

    private FunctionUtilsHexToBin() {

    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе числа 17, метод должен вернуть 10111 - '"
                        + FunctionUtilsHexToBin.hexToBin("-17")
                        + "'"
        );
    }
}
