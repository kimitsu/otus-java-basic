package ru.otus.java.basic.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private final int port;
    private final Dispatcher dispatcher;

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port);
             ExecutorService executorService = Executors.newCachedThreadPool()) {
            System.out.println("Server is started on port " + port);
            while (true) {
                Socket socket;
                try {
                    socket = serverSocket.accept();
                    executorService.execute(() -> processSocket(socket));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processSocket(Socket socket) {
        try {
            byte[] buffer = new byte[8192];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead == -1) {
                System.out.println("Input stream empty");
                return;
            }
            String rawRequest = new String(buffer, 0, bytesRead);
            System.out.println(rawRequest);
            dispatcher.dispatch(rawRequest, socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
