package ru.job4j.lsp;

import java.time.LocalDateTime;

public class Bread extends Food {
    public Bread(String name, LocalDateTime expireDate, LocalDateTime createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
