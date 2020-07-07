package ru.job4j.lsp.car_parking;

import java.util.HashMap;
import java.util.Map;

public class PassengerCarParking implements Parking {

    private final int parkingPlaces;
    private int occupiedPlaces = 0;
    private Map<String, Car> carMap = new HashMap<>();

    public PassengerCarParking(int parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    @Override
    public boolean park(Car car) {
        if (checkFreePlaces() && !carMap.containsKey(car.getNumber())) {
            occupiedPlaces += car.getSize();
            if (occupiedPlaces > parkingPlaces) {
                return false;
            }
            carMap.put(car.getNumber(), car);
            return true;
        }
        return false;
    }

    @Override
    public Car leaveParking(String carNumber) {
        Car rsl = null;
        if (carMap.containsKey(carNumber)) {
            occupiedPlaces -= carMap.get(carNumber).getSize();
            rsl = carMap.remove(carNumber);
        }
        return rsl;
    }

    @Override
    public boolean checkFreePlaces() {
        return occupiedPlaces < parkingPlaces;
    }

    @Override
    public Map<String, Car> getCars() {
        return carMap;
    }
}
