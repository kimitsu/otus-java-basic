package ru.otus.java.basic.hw8.training;

public class FunctionUtilsShiftZeroes {
    public static int shiftZeroes(int input) {
        int number = input > 0 ? input : -input;
        int result = 0;
        while (number != 0) {
            number >>= 1;
            result = 1 + (result << 1);
        }
        return input > 0 ? result : -result;
    }

    private FunctionUtilsShiftZeroes() {
    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе числа 3435, метод должен вернуть 4095 - '"
                        + FunctionUtilsShiftZeroes.shiftZeroes(-3435)
                        + "'"
        );
    }
}
