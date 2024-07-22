package ru.otus.java.basic.http.server;

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
        this.processors.put("/", new HelloWorldRequestProcessor());
        this.processors.put("/bye", new ByeByeWorldRequestProcessor());
        this.processors.put("/calc", new CalculatorRequestProcessor());
        this.processors.put("/sleep", new SleepRequestProcessor());
    }

    public void dispatch(String rawRequest, OutputStream out) throws IOException {
        try {
            HttpRequest request = new HttpRequest(rawRequest);
            request.printInfo(false);
            if (!processors.containsKey(request.getUri())) {
                defaultNotFoundRequestProcessor.process(request, out);
                return;
            }
            processors.get(request.getUri()).process(request, out);
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
