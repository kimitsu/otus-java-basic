package ru.otus.java.basic.http.server.application;

import java.math.BigDecimal;

public class Item {
    private Long id;
    private String title;
    private BigDecimal price;

    public Item(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
