package ru.job4j.lsp.new_car_parking;

import java.util.List;

public interface Parking {

    boolean park(Vehicle vehicle);

    Vehicle leaveParking(String carNumber);

    boolean checkFreePlaces(Vehicle vehicle);

    List<Vehicle> getCars();
}
