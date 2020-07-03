package ru.job4j.lsp.product_store;


import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodStore {
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