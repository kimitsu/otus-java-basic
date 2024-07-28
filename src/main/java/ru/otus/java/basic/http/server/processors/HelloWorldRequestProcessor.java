package ru.otus.java.basic.http.server.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.exceptions.BadRequestException;
import ru.otus.java.basic.http.server.HttpContext;
import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.exceptions.NotAcceptableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HelloWorldRequestProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(HelloWorldRequestProcessor.class);
    @Override
    public void process(HttpRequest request, HttpContext context, OutputStream out) throws IOException, BadRequestException, NotAcceptableException {
        if (!request.accepts("text/html")) {
            throw new NotAcceptableException("text/html");
        }
        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>Hello World</h1><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute " +
                "irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit " +
                "anim id est laborum.</p></body></html>";
        logger.debug("Sending response:{}{}", System.lineSeparator(), response);
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
