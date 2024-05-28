package ru.otus.java.basic.hw10;

import ru.otus.java.basic.hw10.phonebook.PhoneBook;

public class MainApplication {

    /**
     * Test of the PhoneBook class methods
     *
     * @param args unused
     */
    public static void main(String[] args) {
        PhoneBook testBook = new PhoneBook();
        testBook.add("Ivanov", "+78912345678");
        testBook.add("Petrov", "+79995553322");
        testBook.add("Sidoroff", "+00000000000");
        testBook.add("Sidoroff", "+00000000001");
        testBook.add("Sidoroff", "+00000000002");
        testBook.add("Ivanov", "+78912345678");
        testBook.add("Ivanov", "+78912345679");
        testBook.add("Sidoroff", "+00000000000");
        System.out.println(testBook.find("Ivanov").stream().toList());
        System.out.println(testBook.find("Petrov").stream().toList());
        System.out.println(testBook.find("Sidoroff").stream().toList());
        System.out.println(testBook.find("Other Guy") == null);
        System.out.println(testBook.containsPhoneNumber("+00000000001"));
        System.out.println(testBook.containsPhoneNumber("+78912345678"));
        System.out.println(testBook.containsPhoneNumber("+55555555555"));
    }
}
