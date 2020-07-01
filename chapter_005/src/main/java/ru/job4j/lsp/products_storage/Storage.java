package ru.job4j.lsp.products_storage;

import java.util.List;

public interface Storage {
    void add (Food food);

    boolean accept (Food food);

    List<Food> getFoods ();

    List<Food> clear();
}
