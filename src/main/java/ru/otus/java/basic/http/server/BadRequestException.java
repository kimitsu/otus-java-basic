package ru.otus.java.basic.http.server;

public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}
