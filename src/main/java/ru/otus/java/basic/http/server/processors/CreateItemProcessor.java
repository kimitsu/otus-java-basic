package ru.otus.java.basic.http.server.processors;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.application.Item;
import ru.otus.java.basic.http.server.application.ItemsRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CreateItemProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(CreateItemProcessor.class);
    private ItemsRepository itemsRepository;

    public CreateItemProcessor(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        Gson gson = new Gson();
        try {
            Item item = gson.fromJson(request.getBody(), Item.class);
            itemsRepository.add(item);
            String itemJson = gson.toJson(item);
            String response = "" +
                    "HTTP/1.1 201 Created\r\n" +
                    "Content-type: application/json\r\n" +
                    "\r\n" +
                    itemJson;
            logger.debug("Sending response:{}{}", System.lineSeparator(), response);
            out.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (JsonParseException e) {
            throw new BadRequestException("JSON parsing error");
        }
    }
}
