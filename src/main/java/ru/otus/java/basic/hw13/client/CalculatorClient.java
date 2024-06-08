package ru.otus.java.basic.hw13.client;

import ru.otus.java.basic.hw13.server.CalculatorServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 6969;

    public static void main(String[] args) {
        String host = DEFAULT_HOST;
        if (args.length > 0) {
            host = args[1];
        }

        int port = DEFAULT_PORT;
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Connecting to the server...");
            try (Socket socket = new Socket(host, port)) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                receiveOperations(reader);
                sendNumbers(writer);
                sendOperation(writer);
                writer.flush();
                receiveResult(reader);
            } catch (Exception e) {
                System.out.println("Error while communicating with the server:");
                System.out.println(e.getMessage());
            }
            System.out.print("Disconnected from the server. Connect again? Y/N: ");
        } while (scanner.nextLine().equalsIgnoreCase("y"));
    }

    private static void receiveOperations(BufferedReader reader) throws IOException, ServerError {
        System.out.println("Receiving operations from the server...");
        String operations = reader.readLine();
        checkError(operations);
        System.out.println("Available operations: " + operations);
    }

    private static void sendNumbers(BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String number1 = scanner.nextLine();
        System.out.print("Enter the second number: ");
        String number2 = scanner.nextLine();
        writer.write(number1 + " " + number2);
        writer.newLine();
    }

    private static void sendOperation(BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the operation: ");
        String operation = scanner.nextLine();
        writer.write(operation);
        writer.newLine();
    }

    private static void receiveResult(BufferedReader reader) throws IOException, ServerError {
        System.out.println("Receiving the result from the server...");
        String result = reader.readLine();
        checkError(result);
        System.out.println("Result: " + result);
    }

    /**
     * Checks if a message contains a server error
     *
     * @param message a message
     * @throws ServerError if the message contains server error
     * @throws IOException if the message is null
     */
    private static void checkError(String message) throws ServerError, IOException {
        if (message == null) {
            throw new IOException("Could not read from server");
        }

        if (message.startsWith(CalculatorServer.ERROR)) {
            throw new ServerError(message);
        }
    }
}
