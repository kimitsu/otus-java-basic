package ru.otus.java.basic.http.server.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsRepository {
    private List<Item> items;

    public ItemsRepository() {
        this.items = new ArrayList<>(Arrays.asList(
                new Item(1L, "Milk", BigDecimal.valueOf(81)),
                new Item(2L, "Bread", BigDecimal.valueOf(32)),
                new Item(3L, "Cheese", BigDecimal.valueOf(321))
        ));
    }

    public List<Item> getItems() {
        return items;
    }

    public Item add(Item item) {
        Long newId = items.stream().mapToLong(Item::getId).max().orElse(0L) + 1L;
        item.setId(newId);
        items.add(item);
        return item;
    }
}
