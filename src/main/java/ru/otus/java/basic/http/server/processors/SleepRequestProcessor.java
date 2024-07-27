package ru.otus.java.basic.http.server.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class SleepRequestProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(SleepRequestProcessor.class);
    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        try {
            logger.trace("Sleeping for 10 seconds");
            Thread.sleep(10000);
            logger.trace("Waking up");
        } catch (InterruptedException e) {
            logger.error("Thread interrupted", e);
        }
        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>I've slept for so long</h1><p>" + System.currentTimeMillis() + "</p></body></html>";
        logger.debug("Sending response:{}{}", System.lineSeparator(), response);
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
