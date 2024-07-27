package ru.otus.java.basic.http.server.processors;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.ErrorDTO;
import ru.otus.java.basic.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class NotFoundRequestProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(NotFoundRequestProcessor.class);

    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        String response;
        if (request.containsHeader("Accept") && request.getHeader("Accept").equals("application/json")) {
            response = "" +
                    "HTTP/1.1 404 Not Found\r\n" +
                    "Content-Type: application/json\r\n" +
                    "\r\n" +
                    new Gson().toJson(new ErrorDTO("NOT_FOUND", "Invalid endpoint"));
        } else {
            response = "" +
                    "HTTP/1.1 404 Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>404 Not Found</h1></body></html>";
        }
        logger.debug("Sending response:{}{}", System.lineSeparator(), response);
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
