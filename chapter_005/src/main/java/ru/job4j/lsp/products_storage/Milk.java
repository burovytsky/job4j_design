package ru.job4j.lsp.products_storage;

import java.time.LocalDateTime;

public class Milk extends Food {
    public Milk(String name, LocalDateTime expireDate, LocalDateTime createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
