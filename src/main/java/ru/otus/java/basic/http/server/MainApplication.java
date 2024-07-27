package ru.otus.java.basic.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainApplication {
    private static final Logger logger = LogManager.getLogger(MainApplication.class);

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
