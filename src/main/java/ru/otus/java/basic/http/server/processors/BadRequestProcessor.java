package ru.otus.java.basic.http.server.processors;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.exceptions.BadRequestException;
import ru.otus.java.basic.http.server.ErrorDTO;
import ru.otus.java.basic.http.server.HttpContext;
import ru.otus.java.basic.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class BadRequestProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(BadRequestProcessor.class);

    @Override
    public void process(HttpRequest request, HttpContext context, OutputStream out) throws IOException, BadRequestException {
        logger.warn("Bad request", context.getException());
        String response;
        if (request != null && request.accepts("application/json")) {
            response = "" +
                    "HTTP/1.1 400 Bad Request\r\n" +
                    "Content-Type: application/json\r\n" +
                    "\r\n" +
                    new Gson().toJson(new ErrorDTO("BAD_REQUEST", context.getException().getMessage()));
        } else {
            response = "" +
                    "HTTP/1.1 400 Bad Request\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>400 Bad Request</h1><p>" + context.getException().getMessage() + "</p></body></html>";
        }
        logger.debug("Sending response:{}{}", System.lineSeparator(), response);
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
