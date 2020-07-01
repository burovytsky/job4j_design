package ru.job4j.lsp.products_storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        int percentShelfLife = food.getProductExpirationDate();
        if (percentShelfLife >= 100) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getFoods() {
        return foodList;
    }

    @Override
    public List<Food> clear() {
        foodList.clear();
        return foodList;
    }
}
