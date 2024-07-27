package ru.otus.java.basic.http.server;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.application.ItemsRepository;
import ru.otus.java.basic.http.server.processors.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private static final Logger logger = LogManager.getLogger(Dispatcher.class);
    private final Map<String, RequestProcessor> processors = new HashMap<>();
    private RequestProcessor defaultNotFoundRequestProcessor;

    public Dispatcher() {
        this.defaultNotFoundRequestProcessor = new NotFoundRequestProcessor();
        this.processors.put("GET /", new HelloWorldRequestProcessor());
        this.processors.put("GET /bye", new ByeByeWorldRequestProcessor());
        this.processors.put("GET /calc", new CalculatorRequestProcessor());
        this.processors.put("GET /sleep", new SleepRequestProcessor());
        ItemsRepository itemsRepository = new ItemsRepository();
        this.processors.put("GET /items", new GetItemsProcessor(itemsRepository));
        this.processors.put("POST /item", new CreateItemProcessor(itemsRepository));
        this.processors.put("DELETE /item", new DeleteItemProcessor(itemsRepository));
    }

    public void dispatch(String rawRequest, OutputStream out) throws IOException {
        HttpRequest request = null;
        try {
            logger.debug("Got request:{}{}", System.lineSeparator(), rawRequest);
            request = new HttpRequest(rawRequest);
            request.log();
            if (!processors.containsKey(request.getRoutingKey())) {
                logger.warn("Processor for method/uri not found");
                defaultNotFoundRequestProcessor.process(request, out);
                return;
            }
            processors.get(request.getRoutingKey()).process(request, out);
        } catch (BadRequestException e) {
            logger.warn("Bad request", e);
            String response;
            if (request != null && request.containsHeader("Accept")
                    && request.getHeader("Accept").equals("application/json")) {
                response = "" +
                        "HTTP/1.1 400 Bad Request\r\n" +
                        "Content-Type: application/json\r\n" +
                        "\r\n" +
                        new Gson().toJson(new ErrorDTO("BAD_REQUEST", e.getMessage()));
            } else {
                response = "" +
                        "HTTP/1.1 400 Bad Request\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<html><body><h1>400 Bad Request</h1><p>" + e.getMessage() + "</p></body></html>";
            }
            logger.debug("Sending response:{}{}", System.lineSeparator(), response);
            out.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            logger.error("Internal server error", e);
            String response;
            if (request != null && request.containsHeader("Accept")
                    && request.getHeader("Accept").equals("application/json")) {
                response = "" +
                        "HTTP/1.1 500 Internal Server Error\r\n" +
                        "Content-Type: application/json\r\n" +
                        "\r\n" +
                        new Gson().toJson(new ErrorDTO("BAD_REQUEST", e.getMessage()));
            } else {
                response = "" +
                        "HTTP/1.1 500 Internal Server Error\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<html><body><h1>400 Bad Request</h1><p>" + e.getMessage() + "</p></body></html>";
            }
            logger.debug("Sending response:{}{}", System.lineSeparator(), response);
            out.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
}
