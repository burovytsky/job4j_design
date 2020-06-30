package ru.job4j.lsp;

import java.util.List;

public interface FoodStore {

    void addFood(Food food);

    List<Food> showAllItems();
}
