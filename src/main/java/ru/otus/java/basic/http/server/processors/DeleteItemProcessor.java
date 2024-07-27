package ru.otus.java.basic.http.server.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.application.ItemsRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class DeleteItemProcessor implements RequestProcessor {
    private static final Logger logger = LogManager.getLogger(DeleteItemProcessor.class);
    private ItemsRepository itemsRepository;

    public DeleteItemProcessor(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        if (!request.containsParameter("id")) {
            throw new BadRequestException("Item id is not specified");
        }
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String response;
            if (itemsRepository.deleteItem(id)) {
                response = "" +
                        "HTTP/1.1 204 No Content\r\n" +
                        "\r\n";
            } else {
                response = "" +
                        "HTTP/1.1 404 Not Found\r\n" +
                        "\r\n";
            }
            logger.debug("Sending response:{}{}", System.lineSeparator(), response);
            out.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid item id");
        }
    }
}
