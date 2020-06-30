package ru.job4j.lsp.product_store;

import java.util.List;

public interface FoodStore {

    void addFood(Food food);

    List<Food> showAllItems();
}
