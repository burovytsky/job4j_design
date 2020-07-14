package ru.job4j.lsp.car_parking;

import java.util.Objects;

public class Car {

    private String name;
    private final String number;
    private final int size;

    public Car(String name, String number, int size) {
        this.name = name;
        this.number = number;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return size == car.size &&
                Objects.equals(name, car.name) &&
                Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, size);
    }
}
