package ru.job4j.lsp.products_storage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Storage> allStorage;

    public ControlQuality(List<Storage> allStorage) {
        this.allStorage = allStorage;
    }

    public void distribute(Food food) {
        for (Storage storage : allStorage) {
            if (storage.accept(food)) {
                storage.add(food);
                break;
            }
        }
    }

    public void resort(List<Storage> storages) {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storages) {
            foods.addAll(storage.getFoods());
            storage.clear();
        }
        for(Food food : foods) {
            distribute(food);
        }
    }
}
