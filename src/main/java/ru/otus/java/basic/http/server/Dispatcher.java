package ru.otus.java.basic.http.server;

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
    private final Map<String, RequestProcessor> processors = new HashMap<>();
    private RequestProcessor defaultNotFoundRequestProcessor;

    public Dispatcher() {
        this.defaultNotFoundRequestProcessor = new NotFoundRequestProcessor();
        this.processors.put("GET /", new HelloWorldRequestProcessor());
        this.processors.put("GET /bye", new ByeByeWorldRequestProcessor());
        this.processors.put("GET /calc", new CalculatorRequestProcessor());
        this.processors.put("GET /sleep", new SleepRequestProcessor());
        this.processors.put("GET /items", new GetItemsProcessor(new ItemsRepository()));
    }

    public void dispatch(String rawRequest, OutputStream out) throws IOException {
        try {
            HttpRequest request = new HttpRequest(rawRequest);
            request.printInfo(false);
            if (!processors.containsKey(request.getUri())) {
                defaultNotFoundRequestProcessor.process(request, out);
                return;
            }
            processors.get(request.getRoutingKey()).process(request, out);
        } catch (BadRequestException e) {
            e.printStackTrace();
            String response = "" +
                    "HTTP/1.1 400 Bad Request\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>400 Bad Request</h1><p>" + e.getMessage() + "</p></body></html>";
            System.out.println(response);
            out.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
            String response = "" +
                    "HTTP/1.1 500 Internal Server Error\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>500 Internal Server Error</h1></body></html>";
            System.out.println(response);
            out.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
}
