package ru.job4j.lsp.product_store;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ControlQualityTest {

    @Test
    public void whenCheckStorageReturnShop() {
        ControlQuality controlQuality = new ControlQuality();
        Food milk = new Milk("milk", LocalDateTime.now().minusDays(10),
                LocalDateTime.now().plusDays(3), 100, 0);
        FoodStore foodStore = controlQuality.checkStorage(milk);
        assertThat(foodStore, instanceOf(Shop.class));

    }

    @Test
    public void whenCheckStorageReturnWarehouse() {
        ControlQuality controlQuality = new ControlQuality();
        Food bread = new Bread("brad", LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(10), 50, 0);
        FoodStore foodStore = controlQuality.checkStorage(bread);
        assertThat(foodStore, instanceOf(Warehouse.class));
    }

    @Test
    public void whenCheckStorageReturnTrash() {
        ControlQuality controlQuality = new ControlQuality();
        Food fish = new Fish("brad", LocalDateTime.now().minusDays(20),
                LocalDateTime.now().minusDays(2), 50, 0);
        FoodStore foodStore = controlQuality.checkStorage(fish);
        assertThat(foodStore, instanceOf(Trash.class));
    }
}