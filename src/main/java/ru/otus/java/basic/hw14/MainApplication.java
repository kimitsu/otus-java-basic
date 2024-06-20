package ru.otus.java.basic.hw14;

public class MainApplication {
    private static long startTime = 0;

    /**
     * Prints a message and starts a timer
     *
     * @param message a message to print
     */
    private static void startMeasure(String message) {
        if (message != null) {
            System.out.println(message);
        }
        startTime = System.currentTimeMillis();
    }

    /**
     * Prints a message and a number of milliseconds elapsed since the last call of startMeasure
     *
     * @param message a message to print
     * @throws IllegalStateException if called before startMeasure or if it's midnight of January 1, 1970 UTC
     */
    private static void endMeasure(String message) {
        if (startTime == 0) {
            throw new IllegalStateException("startMeasure must be called before endMeasure");
        }
        if (message != null) {
            System.out.print(message);
        }
        System.out.println("... " + (System.currentTimeMillis() - startTime) + " ms");
    }

    /**
     * Creates and calculates an array
     *
     * @param elementCount number of elements in the array
     * @return the array
     */
    private static double[] createCalculatedArray(int elementCount) {
        startMeasure("Creating and calculating array of " + elementCount + " elements");
        double[] array = new double[elementCount];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        endMeasure("Calculation complete");
        return array;
    }

    /**
     * Creates and calculates an array using threads
     *
     * @param elementCount number of elements in the array
     * @param threadsCount number of threads to use for calculation
     * @return the array
     */
    private static double[] createCalculatedArrayThreaded(int elementCount, int threadsCount) {
        startMeasure("Creating and calculating array of " + elementCount + " elements using " + threadsCount + " threads");
        double[] array = new double[elementCount];
        Thread[] threads = new Thread[threadsCount];
        for (int currentThread = 0; currentThread < threadsCount; currentThread++) {
            final int startIndex = currentThread * (array.length / threadsCount);
            final int endIndex = currentThread == threadsCount - 1
                    ? array.length
                    : (currentThread + 1) * (array.length / threadsCount);
            threads[currentThread] = new Thread(() -> {
                for (int i = startIndex; i < endIndex; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }

            });
            threads[currentThread].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        endMeasure("Calculation complete");
        return array;
    }

    /**
     * Tests the methods
     *
     * @param args unused
     */
    public static void main(String[] args) {
        createCalculatedArray(100_000_000);
        createCalculatedArrayThreaded(100_000_000, 8);
    }
}
