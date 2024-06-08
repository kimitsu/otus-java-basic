package ru.otus.java.basic.hw13.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class CalculatorServer {
    private static final int DEFAULT_PORT = 6969;
    public static final String ERROR = "ERROR: ";
    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.printf("Starting server on port %d...%n", port);
        try (ServerSocket socket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Awaiting connection...");
                processClientConnection(socket);
            }
        } catch (IOException e) {
            System.out.println("Could not start server:");
            System.out.println(e.getMessage());
        }
    }

    private static void processClientConnection(ServerSocket socket) {
        try (Socket client = socket.accept()) {
            System.out.printf("Client connection from %s%n", client.getInetAddress().getHostAddress());
            var reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            var writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            try {
                sendOperations(writer);
                writer.flush();
                int[] numbers = receiveNumbers(reader);
                if (numbers.length != 2) {
                    throw new Exception("Illegal number of numbers");
                }
                Operation operation = receiveOperation(reader);
                sendResult(writer, operation.operate(numbers[0], numbers[1]));
                writer.flush();
            } catch (Exception e) {
                sendError(writer, e);
                writer.flush();
            }
        } catch (Exception e) {
            System.out.println("Connection error:");
            System.out.println(e.getMessage());
        }
        System.out.println("Client disconnected.");
    }

    private static void sendOperations(BufferedWriter writer) throws IOException {
        System.out.println("Sending operations...");
        writer.write(Arrays.stream(Operation.values())
                .map(Operation::getName)
                .peek(operation -> System.out.println("Operation: " + operation))
                .collect(Collectors.joining(", ")));
        writer.newLine();
    }

    private static int[] receiveNumbers(BufferedReader reader) throws IOException {
        System.out.println("Receiving numbers... ");
        return Arrays.stream(reader.readLine()
                        .split(" ", 2))
                .mapToInt(Integer::parseInt)
                .peek(number -> System.out.println("Number: " + number))
                .toArray();

    }

    private static Operation receiveOperation(BufferedReader reader) throws IOException, NoSuchElementException {
        System.out.println("Receiving operation...");
        String operationName = reader.readLine();
        return Arrays.stream(Operation.values())
                .filter(operation -> Objects.equals(operation.getName(), operationName))
                .peek(operation -> System.out.println("Operation: " + operation.getName()))
                .findAny()
                .orElseThrow();
    }

    private static void sendResult(BufferedWriter writer, int number) throws IOException {
        System.out.printf("Sending result (%d)...%n", number);
        writer.write("" + number);
        writer.newLine();
    }

    private static void sendError(BufferedWriter writer, Exception e) {
        System.out.printf("Sending error: %s%n", e.getMessage());
        try {
            writer.write(ERROR + e.getClass().getName() + " " + e.getMessage());
        } catch (Exception _) {
        }
    }
}
