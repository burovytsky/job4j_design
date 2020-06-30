package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements FoodStore {
    List<Food> foodList = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> showAllItems() {
        return foodList;
    }
}
