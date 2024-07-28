package ru.otus.java.basic.http.server.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.processors.ByeByeWorldRequestProcessor;

import java.math.BigDecimal;
import java.util.*;

public class ItemsRepository {
    private static final Logger logger = LogManager.getLogger(ItemsRepository.class);
    private HashMap<Long, Item> items;

    public ItemsRepository() {
        this.items = new HashMap<>();
        this.items.put(1L, new Item(1L, "Milk", BigDecimal.valueOf(81)));
        this.items.put(2L, new Item(2L, "Bread", BigDecimal.valueOf(32)));
        this.items.put(3L, new Item(3L, "Cheese", BigDecimal.valueOf(321)));
        logger.trace("Item repository created");
    }

    public Collection<Item> getItems() {
        return items.values();
    }

    public boolean containsItem(Long id) {
        return items.containsKey(id);
    }

    public synchronized boolean deleteItem(Long id) {
        if (!containsItem(id)) return false;
        items.remove(id);
        logger.debug("Removed item with id = {}", id);
        return true;
    }

    public synchronized Item add(Item item) {
        Long newId = items.keySet().stream().max(Long::compareTo).map((value) -> value + 1L).orElse(1L);
        item.setId(newId);
        items.put(newId, item);
        logger.debug("Added item with id = {}", newId);
        return item;
    }
}
