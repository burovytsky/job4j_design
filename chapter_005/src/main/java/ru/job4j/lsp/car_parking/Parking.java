package ru.job4j.lsp.car_parking;

public interface Parking {
    void park(Car car);

    void leaveParking(Car car);

    boolean checkFreePlaces();
}
