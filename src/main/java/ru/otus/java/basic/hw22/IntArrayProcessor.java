package ru.otus.java.basic.hw22;

public class IntArrayProcessor {
    /**
     * Creates an array of integers from the elements of a source array,
     * starting from the element following the last one in the source array.
     *
     * @param array a source array
     * @return the copy of the source array starting from the element following the last one in the source array
     * @throws RuntimeException in case the source array does not contain ones
     */
    public static int[] getTrimmedUntilLastOne(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {
                int[] result = new int[array.length - i - 1];
                System.arraycopy(array, i + 1, result, 0, array.length - i - 1);
                return result;
            }
        }
        throw new RuntimeException("The array does not contain any ones");
    }

    /**
     * Checks if an array contains ones and twos only and has at least one of each.
     *
     * @param array an array
     * @return true if the array contains ones and twos only, false if other numbers present
     * or if a one or a two is missing
     */
    public static boolean isArrayContainsOnesAndTwosOnly(int[] array) {
        boolean isOnePresent = false;
        boolean isTwoPresent = false;
        for (int i : array) {
            if (i != 1 && i != 2) {
                return false;
            }
            if (i == 1) {
                isOnePresent = true;
            } else {
                isTwoPresent = true;
            }
        }
        return isOnePresent && isTwoPresent;
    }

    private IntArrayProcessor() {
    }
}
