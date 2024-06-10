package ru.otus.java.basic.hw12.jim;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class FileEditor {
    private FileEditor() {
    }

    /**
     * Prints file contents to the console
     *
     * @param file file to print
     * @return true if successful, false otherwise
     */
    private static boolean printContents(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Reading file contents...");
            System.out.println("Line Num | ");
            int count = 1;
            for (String line = reader.readLine(); line != null; line = reader.readLine(), count++) { // war crime
                System.out.printf("%8d | %s%n", count, line);
            }
            System.out.println("Reached the end of file.");
        } catch (IOException e) {
            System.out.println("Cannot read file! Try again.");
            return false;
        }
        return true;
    }

    /**
     * Asks user to input a line
     *
     * @return a line followed by the line separator, or null if the user entered /q
     */
    private static String requestLine() {
        System.out.println("Enter a line to append to the file or type /q to quit (escape /q as //q):");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("/q")) {
            return null;
        }
        if (line.equals("//q")) {
            return "/q" + System.lineSeparator();
        }
        return line + System.lineSeparator();
    }

    /**
     * Appends a line to a file
     *
     * @param file a file to append a line to
     * @param line a line to append to a file
     * @return true if successful, false otherwise
     */
    private static boolean appendFile(File file, String line) {
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            stream.write(line.getBytes(Charset.defaultCharset()));
            System.out.println("OK.");
        } catch (IOException e) {
            System.out.println("Cannot write file! Try again.");
            return false;
        }
        return true;
    }

    /**
     * Prints file contents and asks the user to input lines to append to the file
     *
     * @param file a file to print and append lines to
     */
    public static void editFile(File file) {
        if (!printContents(file)) {
            return;
        }
        for (String line = requestLine(); line != null; line = requestLine()) { // actually "for" crime
            if (!appendFile(file, line)) {
                return;
            }
        }
    }
}
