package ru.job4j.lsp.product_store;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ControlQuality {
    public FoodStore checkStorage(Food food) {
        FoodStore foodStore = getFoodStore(food);
        foodStore.addFood(food);
        return foodStore;
    }

    private FoodStore getFoodStore(Food food) {
        FoodStore rsl;
        int percentShelfLife = getProductExpirationDate(food);
        if (percentShelfLife >= 25 && percentShelfLife <= 100) {
            rsl = new Shop();
            if (percentShelfLife >= 75) {
                setNewDiscount(food);
            }
        } else if (percentShelfLife < 25) {
            rsl = new Warehouse();
        } else {
            rsl = new Trash();
        }
        return rsl;
    }

    private void setNewDiscount(Food food) {
        food.setDiscount(30);
    }

    private int getProductExpirationDate(Food food) {
        int shelfLife = (int) ChronoUnit.DAYS.between(food.getExpireDate(), food.getCreateDate());
        int daysPassed = (int) ChronoUnit.DAYS.between(LocalDateTime.now(), food.getCreateDate());
        return 100 - (daysPassed * 100) / shelfLife;
    }
}
