package ru.otus.java.basic.hw5.training;
import java.util.Arrays;
import java.util.Random;

public class ArrayUtilsTwoDigitNumbers {
    public static int[] fillArrayByTwoDigitNumbers(int[] inputArray) {
        Random rng = new Random();
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = rng.nextInt(90) + 10;
        }
        return inputArray;
    }
    private ArrayUtilsTwoDigitNumbers() {

    }

    public static void main(String[] args) {
        System.out.println(
                "При вводе массива длиной 5, метод должен вернуть массив случайных двузначных чисел - '"
                        + Arrays.toString(ArrayUtilsTwoDigitNumbers.fillArrayByTwoDigitNumbers(new int[509]))
                        +"'"
        );
    }
}