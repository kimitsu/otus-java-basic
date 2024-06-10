package ru.otus.java.basic.hw12.jim;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class FilePicker {
    private FilePicker() {
    }
    /**
     * Prints a list of files and directories contained in a chosen directory
     *
     * @param root a directory to list
     */
    private static void printFileList(File root) {
        String path = root.getAbsolutePath();
        try {
            path = root.getCanonicalPath();
        } catch (IOException e) {
            // Ignore and leave path as is
        }
        System.out.println("Listing files in: " + path);
        if (path.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .filter(File.separator::equals)
                .count()
                > 1) {
            System.out.println("    | ..");
        }
        File[] fileList = root.listFiles();
        if (fileList == null) {
            System.out.println("-- No files found --");
            return;
        }
        Arrays.sort(fileList, FilePicker::compareFiles);
        for (File file : fileList) {
            System.out.println((file.isDirectory() ? "DIR | " : "    | ") + file.getName());
        }

    }

    /**
     * Compares a and b by name if both a and b are either files or directories,
     * otherwise considers directories less than files
     *
     * @param a file a
     * @param b file b
     * @return 1 if a greater than b, 0 if equal, -1 if less
     */
    private static int compareFiles(File a, File b) {
        if (a.isDirectory() && !b.isDirectory()) {
            return -1;
        } else if (b.isDirectory() && !a.isDirectory()) {
            return 1;
        } else {
            return a.getName().compareTo(b.getName());
        }
    }

    /**
     * Asks user to input a file or directory name
     *
     * @return a string that the user have entered
     */
    private static String requestUserInput() {
        System.out.print("Enter file or directory name or press Enter to quit: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Prints directory contents and asks user to pick or create a file.
     * Allows the user to traverse the directory structure.
     *
     * @return the file that the user have chosen, or null if the file cannot be opened or written to
     */
    public static File getFile() {
        return getFile(null);
    }

    /**
     * If path is null, prints directory contents and asks user to pick or create a file
     * and allows the user to traverse the directory structure.
     * If path is specified, attempts to choose the file by that path.
     *
     * @param path path of the file to choose, or null to allow for manual choice
     * @return the file that the user have chosen,
     * or null if the file cannot be opened or written to, or other error have occurred
     */
    public static File getFile(String path) {
        File root = new File(".");
        do {
            printFileList(root);
            String userInput = path == null ? requestUserInput() : path;
            if (userInput.isEmpty()) {
                return null;
            }
            try {
                File file = Path.of(userInput).isAbsolute()
                        ? new File(userInput)
                        : new File(root, userInput);
                if (!file.exists()) {
                    File newFile = createFile(file);
                    if (newFile != null) return newFile;
                } else if (file.isFile()) {
                    if (file.canWrite()) {
                        return file;
                    } else {
                        System.out.println("Cannot write file. Try again.");
                    }
                } else {
                    root = file;
                }
            } catch (Exception e) {
                System.out.println("Couldn't open file or directory. Try again.");
            }
        } while (path == null);
        return null;
    }

    private static File createFile(File file) {
        System.out.println("File does not exist. Attempt to create? Y/N: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (Exception e) {
                System.out.println("Cannot create file. Try again.");
            }
        }
        return null;
    }
}
