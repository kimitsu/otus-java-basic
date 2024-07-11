package ru.otus.java.basic.hw20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApplication {
    /**
     * Asks to input a filename and a line of text, then counts the occurrences of that text in that file
     * and prints the result.
     * Example:
     * Enter the file name: test.txt
     * Enter the text to search: test
     * Found 3 matches
     *
     * @param args unused
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            System.out.print("Enter the text to search: ");
            char[] textToSearch = scanner.nextLine().toCharArray();
            if (textToSearch.length == 0) {
                System.out.println("Text should not be empty");
                return;
            }
            try (Reader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
                readCountOccurrencesAndPrint(reader, textToSearch);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Cannot read the file");
            }
        }
    }

    /**
     * Reads characters from a reader and counts occurrences of textToSearch, then prints the result.
     *
     * @param reader       a reader
     * @param textToSearch a text to search
     * @throws IOException in case of a reader failure
     */
    private static void readCountOccurrencesAndPrint(Reader reader, char[] textToSearch) throws IOException {
        int textLength = textToSearch.length;
        int matchStart = textLength;
        int matchCount = 0;
        char[] buffer = new char[textLength * 2];
        // Read into the second half of the buffer
        do {
            int charsRead = readForSure(reader, buffer, textLength, textLength);
            if (charsRead == 0) {
                break;
            }
            // The matching loop.
            // On the first read will start from matchStart = textLength,
            // so will only check if the read portion matches the textToSearch.
            // Notably, if charsRead < textLength, should exit the loop.
            // On consequent reads, the second half of the buffer is copied to the first half,
            // and matching starts from matchStart = 1 up to charsRead.
            while (matchStart <= charsRead) {
                if (match(buffer, textToSearch, matchStart)) {
                    matchCount++;
                }
                matchStart++;
            }
            System.arraycopy(buffer, textLength, buffer, 0, textLength);
            matchStart = 1;
        } while (true);
        System.out.println("Found " + matchCount + " matches");
    }

    /**
     * Reads up to a specified number of characters from a reader despite potential IO blocking
     *
     * @param reader a reader
     * @param buffer a buffer
     * @param index  a starting index in the buffer to place the read data
     * @param length a number of characters to read
     * @return the number of characters that was possible to read until the end of stream,
     * or 0 if the stream have reached the end
     * @throws IOException in case of reader failure
     */
    private static int readForSure(Reader reader, char[] buffer, int index, int length) throws IOException {
        int currentIndex = index;
        int totalLength = 0;
        while (totalLength < length) {
            int readLength = reader.read(buffer, currentIndex, length - totalLength);
            if (readLength == -1) {
                break;
            }
            totalLength += readLength;
            currentIndex += readLength;
        }
        return totalLength;
    }

    /**
     * Checks if chars array starting from start index matches with matchChars array.
     *
     * @param chars      an array to inspect
     * @param matchChars an array to match against
     * @param start      a start index of the array to inspect
     * @return true if matches, false if not
     */
    private static boolean match(char[] chars, char[] matchChars, int start) {
        for (int i = 0; i < matchChars.length; i++) {
            if (chars[i + start] != matchChars[i]) {
                return false;
            }
        }
        return true;
    }
}
