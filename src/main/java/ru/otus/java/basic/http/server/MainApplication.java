package ru.otus.java.basic.http.server;

public class MainApplication {
    public static void main(String[] args) {
        new HttpServer(6969).start();
    }
}
