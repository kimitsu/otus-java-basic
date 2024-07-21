package ru.otus.java.basic.http.server.processors;

import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class NotFoundRequestProcessor implements RequestProcessor {
    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        String response = "" +
                "HTTP/1.1 404 Not Found\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>404 Not Found</h1></body></html>";
        System.out.println(response);
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
