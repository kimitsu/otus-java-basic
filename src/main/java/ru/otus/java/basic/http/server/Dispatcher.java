package ru.otus.java.basic.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.application.ItemsRepository;
import ru.otus.java.basic.http.server.exceptions.BadRequestException;
import ru.otus.java.basic.http.server.exceptions.NotAcceptableException;
import ru.otus.java.basic.http.server.processors.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private static final Logger logger = LogManager.getLogger(Dispatcher.class);
    private final Map<String, RequestProcessor> processors = new HashMap<>();
    private RequestProcessor defaultNotFoundRequestProcessor;
    private RequestProcessor defaultBadRequestProcessor;
    private RequestProcessor defaultInternalServerErrorProcessor;
    private RequestProcessor defaultNotAcceptableProcessor;

    public Dispatcher() {
        this.defaultNotFoundRequestProcessor = new NotFoundRequestProcessor();
        this.defaultBadRequestProcessor = new BadRequestProcessor();
        this.defaultInternalServerErrorProcessor = new InternalServerErrorProcessor();
        this.defaultNotAcceptableProcessor = new NotAcceptableProcessor();
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
        HttpContext context = new HttpContext();
        try {
            logger.debug("Got request:{}{}", System.lineSeparator(), rawRequest);
            request = new HttpRequest(rawRequest);
            request.log();
            if (!processors.containsKey(request.getRoutingKey())) {
                defaultNotFoundRequestProcessor.process(request, context, out);
                return;
            }
            processors.get(request.getRoutingKey()).process(request, context, out);
        } catch (BadRequestException e) {
            context.setException(e);
            try {
                defaultBadRequestProcessor.process(request, context, out);
            } catch (Exception exception) {
                logger.error("Unexpected exception", e);
            }
        } catch (NotAcceptableException e) {
            context.setException(e);
            try {
                defaultNotAcceptableProcessor.process(request, context, out);
            } catch (Exception exception) {
                logger.error("Unexpected exception", e);
            }
        } catch (Exception e) {
            context.setException(e);
            try {
                defaultInternalServerErrorProcessor.process(request, context, out);
            } catch (Exception exception) {
                logger.error("Unexpected exception", e);
            }
        }
    }
}
