package ru.otus.java.basic.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApplication {
    private static final Logger logger = LogManager.getLogger(MainApplication.class);
    public static void main(String[] args) {
        logger.debug("Application started");
        new HttpServer(6969).start();
        logger.debug("Application stopped");
    }
}
