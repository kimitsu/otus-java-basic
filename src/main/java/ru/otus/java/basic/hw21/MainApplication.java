package ru.otus.java.basic.hw21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApplication {
    private static char lastPrintedCharacter = 'C';
    private static final Object characterPrintingMonitor = new Object();

    /**
     * Executes three tasks in a thread pool to print a sequence ABCABCABCABCABC,
     * where each thread only prints one kind of character
     *
     * @param args unused
     */
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            executorService.execute(() -> {
                printCharacterInOrder('A', 'C', 5);
            });
            executorService.execute(() -> {
                printCharacterInOrder('B', 'A', 5);
            });
            executorService.execute(() -> {
                printCharacterInOrder('C', 'B', 5);
            });
            executorService.shutdown();
        }
    }

    /**
     * Repeatedly waits for lastPrintedCharacter to become characterToWait,
     * then prints characterToPrint and updates lastPrintedCharacter.
     *
     * @param characterToPrint a character to print
     * @param characterToWait  a character to wait for
     * @param number           a number of times to repeat the process
     */
    private static void printCharacterInOrder(char characterToPrint, char characterToWait, int number) {
        synchronized (characterPrintingMonitor) {
            for (int i = 0; i < number; i++) {
                while (lastPrintedCharacter != characterToWait) {
                    try {
                        characterPrintingMonitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(characterToPrint);
                lastPrintedCharacter = characterToPrint;
                characterPrintingMonitor.notifyAll();
            }
        }
    }
}
