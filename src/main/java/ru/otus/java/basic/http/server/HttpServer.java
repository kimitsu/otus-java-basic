package ru.otus.java.basic.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private final int port;
    private final Dispatcher dispatcher;

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is started on port " + port);
            try (Socket socket = serverSocket.accept()) {
                byte[] buffer = new byte[8192];
                int bytesRead = socket.getInputStream().read(buffer);
                String rawRequest = new String(buffer, 0, bytesRead);
                System.out.println(rawRequest);
                dispatcher.dispatch(rawRequest, socket.getOutputStream());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
