package ru.otus.java.basic.hw8;

public class MainApplication {

    /**
     * Takes 4 by 4 array of strings as an input and calculates the sum of each of the elements converted to an int
     *
     * @param array 4 by 4 array
     * @return sum of the elements of the array, if each of the elements is converted to an int
     */
    public static long sum4by4(String[][] array) {
        if (array.length != 4) {
            throw new AppArraySizeException("Array size should be 4 by 4");
        }
        long result = 0;
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new AppArraySizeException("Array size should be 4 by 4");
            }
            for (int j = 0; j < 4; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Invalid integer in cell [" + i + ", " + j + "]");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] array = {
                {"0", "1", "2", "3"},
                {"4", "5", "6", "7"},
                {"-1", "-2", "-3", "-4"},
                {"-5", "-6", "-7", "-8"}};
        try {
            System.out.println(sum4by4(array));
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.printf(e.getMessage());
        }
    }
}
