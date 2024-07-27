package ru.otus.java.basic.http.server.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.http.server.BadRequestException;
import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.application.Item;
import ru.otus.java.basic.http.server.application.ItemsRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GetItemsProcessor implements RequestProcessor {
    private ItemsRepository itemsRepository;

    public GetItemsProcessor(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void process(HttpRequest request, OutputStream out) throws IOException, BadRequestException {
        List<Item> items = itemsRepository.getItems();
        Gson gson = new Gson();
        String itemsJson = gson.toJson(items);
        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-type: application/json\r\n" +
                "\r\n" +
                itemsJson;
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
