package ru.otus.java.basic.http.server;

public class MainApplication {

    /*
    Домашнее задание
    - Добавить логировние (не JUL)
    - Парсинг заголовков запроса в Map<String, String>
    - * Добавить возможность удалять продукты DELETE /items?id=10
     */
    public static void main(String[] args) {
        new HttpServer(6969).start();
    }
}
