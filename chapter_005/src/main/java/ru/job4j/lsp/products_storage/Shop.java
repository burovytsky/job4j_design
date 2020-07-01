package ru.job4j.lsp.products_storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;

        int percentShelfLife = food.getProductExpirationDate();
        if (percentShelfLife >= 25 && percentShelfLife <= 100) {
            if (percentShelfLife >= 75) {
                food.setDiscount(30);
                food.setPrice(food.getPrice() - (food.getPrice() / 100 * food.getDiscount()));
            }
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
