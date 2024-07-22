package ru.otus.java.basic.http.server.processors;

import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class SleepRequestProcessor implements RequestProcessor {
    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>I've slept for so long</h1><p>" + System.currentTimeMillis() + "</p></body></html>";
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
