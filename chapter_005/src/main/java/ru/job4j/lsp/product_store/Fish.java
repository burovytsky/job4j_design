package ru.job4j.lsp.product_store;

import java.time.LocalDateTime;

public class Fish extends Food{
    public Fish(String name, LocalDateTime expireDate, LocalDateTime createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}