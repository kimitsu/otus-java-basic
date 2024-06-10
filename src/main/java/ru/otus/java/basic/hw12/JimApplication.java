package ru.otus.java.basic.hw12;

import ru.otus.java.basic.hw12.jim.FileEditor;
import ru.otus.java.basic.hw12.jim.FilePicker;

import java.io.File;

public class JimApplication {
    /**
     * Simple file editor
     *
     * @param args (optional) relative or absolute path to the file
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            File file = FilePicker.getFile(args[0]);
            FileEditor.editFile(file);
            return;
        }
        while (true) {
            File file = FilePicker.getFile();
            if (file == null) {
                return;
            }
            FileEditor.editFile(file);
        }
    }
}
