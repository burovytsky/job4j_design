package ru.job4j.lsp.product_store;

import java.time.LocalDateTime;
import java.util.Objects;

public class Food {
    ControlQuality controlQuality;
    private String name;
    private LocalDateTime expireDate;
    private LocalDateTime createDate;
    private double price;
    private double discount;

    public Food(String name, LocalDateTime expireDate, LocalDateTime createDate, double price, double discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        this.price = price - (price/100 * discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 &&
                Double.compare(food.discount, discount) == 0 &&
                Objects.equals(name, food.name) &&
                Objects.equals(expireDate, food.expireDate) &&
                Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expireDate, createDate, price, discount);
    }
}