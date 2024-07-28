package ru.otus.java.basic.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private static final Logger logger = LogManager.getLogger(HttpServer.class);
    private final int port;
    private final Dispatcher dispatcher;

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port);
             ExecutorService executorService = Executors.newCachedThreadPool()) {
            logger.info("Server is started on port {}", port);
            while (true) {
                Socket socket;
                try {
                    socket = serverSocket.accept();
                    logger.debug("Accepted connection from {}", socket.getInetAddress());
                    executorService.execute(() -> processSocket(socket));
                } catch (IOException e) {
                    logger.error("Connection socket error", e);
                }
            }
        } catch (IOException e) {
            logger.fatal("Server socket error", e);
        }
    }

    private void processSocket(Socket socket) {
        try {
            byte[] buffer = new byte[8192];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead == -1) {
                logger.warn("Input stream empty");
                return;
            }
            String rawRequest = new String(buffer, 0, bytesRead);
            dispatcher.dispatch(rawRequest, socket.getOutputStream());
        } catch (IOException e) {
            logger.error("Connection socket error", e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                logger.error("Error while closing socket", e);
            }
        }
    }

}
