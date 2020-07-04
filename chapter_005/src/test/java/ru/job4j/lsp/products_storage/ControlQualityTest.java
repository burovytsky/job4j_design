package ru.job4j.lsp.products_storage;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ControlQualityTest {

    @Test
    public void whenAddFoodToShop() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<Storage> allStorage = List.of(shop, trash, warehouse);
        ControlQuality controlQuality = new ControlQuality(allStorage);
        Food milk = new Milk("milk", LocalDateTime.now().plusDays(3),
                LocalDateTime.now().minusDays(10), 100, 0);
        controlQuality.distribute(milk);
        assertTrue(shop.getFoods().contains(milk));
        assertThat(milk.getPrice(), is(70.0));
    }

    @Test
    public void whenAddFoodToWarehouse() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<Storage> allStorage = List.of(shop, trash, warehouse);
        ControlQuality controlQuality = new ControlQuality(allStorage);
        Food bread = new Bread("brad", LocalDateTime.now().plusDays(10),
                LocalDateTime.now().minusDays(1), 50, 0);
        controlQuality.distribute(bread);
        assertTrue(warehouse.getFoods().contains(bread));
    }

    @Test
    public void whenAddFoodToTrash() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<Storage> allStorage = List.of(shop, trash, warehouse);
        ControlQuality controlQuality = new ControlQuality(allStorage);
        Food fish = new Fish("brad", LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(20), 50, 0);
        controlQuality.distribute(fish);
        assertTrue(trash.getFoods().contains(fish));
    }

    @Test
    public void whenResortFoods() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<Storage> allStorage = List.of(shop, trash, warehouse);
        ControlQuality controlQuality = new ControlQuality(allStorage);
        Food fish = new Fish("brad", LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(20), 50, 0);
        Food bread = new Bread("brad", LocalDateTime.now().plusDays(10),
                LocalDateTime.now().minusDays(1), 50, 0);
        Food milk = new Milk("milk", LocalDateTime.now().plusDays(3),
                LocalDateTime.now().minusDays(10), 100, 0);

        controlQuality.distribute(fish);
        controlQuality.distribute(bread);
        controlQuality.distribute(milk);
        bread.setCreateDate(LocalDateTime.now().minusDays(10));
        controlQuality.resort(allStorage);
        assertThat(shop.getFoods().size(), is(2));
        assertThat(warehouse.getFoods().size(), is(0));
    }

}