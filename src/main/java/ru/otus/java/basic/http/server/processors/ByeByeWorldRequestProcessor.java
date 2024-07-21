package ru.otus.java.basic.http.server.processors;

import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ByeByeWorldRequestProcessor implements RequestProcessor {
    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>Bye Bye World</h1></body></html>";
        int n = 10 / 0;
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
