package ru.otus.java.basic.hw4;

public class MainApplication {

    public static void main(String[] args) {
        testUsers();
        testBox();
    }

    /**
     * Создает массив из 10 пользователей и печатает информацию по пользователям старше 40 лет
     */
    private static void testUsers() {
        User[] users = {
                new User("Иванов", "Иван", "Иванович", 1990, "ivanov@mail.ru"),
                new User("Петров", "Петр", "Петрович", 1991, "petrov@mail.ru"),
                new User("Сидоров", "Сидор", "Сидорович", 1989, "sidorov@mail.ru"),
                new User("Пушкин", "Александр", "Сергеевич", 1799, "pushka@mail.ru"),
                new User("Лермонтов", "Михаил", "Юрьевич", 1814, "miha@mail.ru"),
                new User("Гоголь", "Николай", "Васильевич", 1809, "gogol_mogol@mail.ru"),
                new User("Достоевский", "Фёдор", "Михайлович", 1821, "axeman@mail.ru"),
                new User("Толстой", "Лев", "Николаевич", 1828, "leo@mail.ru"),
                new User("Тургенев", "Иван", "Сергеевич", 1818, "eagle@orange.fr"),
                new User("Чехов", "Антон", "Павлович", 1860, "gunman@mail.de"),
        };
        for (User user : users) {
            if (user.getAgeYears().orElse(0) > 40) {
                user.print();
            }
        }
    }

    /**
     * Тестирует разнообразные манипуляции с коробками
     */
    private static void testBox() {
        String item = null;
        Box box1 = new Box("черный", 3, 4, 5);
        box1.print();
        box1.open();
        try {
            box1.put("кот");
        } catch (BoxIsClosedException | BoxIsOccupiedException _) {
        }
        box1.close();
        Box box2 = new Box("красный", 3, 1, 2);
        box2.print();
        box2.open();
        try {
            box2.put("мышь");
        } catch (BoxIsClosedException | BoxIsOccupiedException _) {
        }
        box2.close();
        box1.paint("синий");
        try {
            item = box1.eject();
        } catch (BoxIsClosedException _) {
            box1.open();
            try {
                item = box1.eject();
            } catch (BoxIsEmptyException _) {
            }
        } catch (BoxIsEmptyException _) {
        }
        box1.close();
        if (item != null) {
            try {
                box2.put(item);
            } catch (BoxIsClosedException _) {
                box2.open();
                try {
                    box2.put(item);
                } catch (BoxIsOccupiedException _) {
                    String contents = box2.eject();
                    box2.put(item);
                    item = contents;
                }
            } catch (BoxIsOccupiedException _) {
                String contents = box2.eject();
                box2.put(item);
                item = contents;
            }
        }
        box2.close();
        if (item != null) {
            try {
                box1.put(item);
            } catch (BoxIsClosedException _) {
                box1.open();
                try {
                    box1.put(item);
                } catch (BoxIsOccupiedException _) {
                    String contents = box1.eject();
                    box1.put(item);
                    item = contents;
                }
            } catch (BoxIsOccupiedException _) {
                String contents = box1.eject();
                box1.put(item);
                item = contents;
            }
        }
        box1.print();
        box2.print();
    }
}
