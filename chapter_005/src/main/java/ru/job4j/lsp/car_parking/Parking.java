package ru.job4j.lsp.car_parking;

import java.util.Map;

public interface Parking {

    boolean park(Car car);

    Car leaveParking(String carNumber);

    boolean checkFreePlaces(Car car);

    Map<String, Car> getCars();
}
