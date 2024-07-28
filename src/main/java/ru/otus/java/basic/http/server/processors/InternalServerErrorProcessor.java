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

public class InternalServerErrorProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(InternalServerErrorProcessor.class);

    @Override
    public void process(HttpRequest request, HttpContext context, OutputStream out) throws IOException, BadRequestException {
        logger.error("Internal server error", context.getException());
        String response;
        if (request != null && request.accepts("application/json")) {
            response = "" +
                    "HTTP/1.1 500 Internal Server Error\r\n" +
                    "Content-Type: application/json\r\n" +
                    "\r\n" +
                    new Gson().toJson(new ErrorDTO("INTERNAL_ERROR", context.getException().getMessage()));
        } else {
            response = "" +
                    "HTTP/1.1 500 Internal Server Error\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>500 Internal Server Error</h1><p>" + context.getException().getMessage() + "</p></body></html>";
        }
        logger.debug("Sending response:{}{}", System.lineSeparator(), response);
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
