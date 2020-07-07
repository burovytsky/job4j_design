package ru.job4j.lsp.car_parking;

import java.util.HashMap;
import java.util.Map;

public class TruckParking implements Parking {
    private final int parkingPlaces;
    private Map<String, Car> carMap = new HashMap<>();
    private int occupiedPlaces;

    public TruckParking(int parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    @Override
    public boolean park(Car car) {
        if (checkFreePlaces() && car.getSize() == 2 && !carMap.containsKey(car.getNumber())) {
            carMap.put(car.getNumber(), car);
            occupiedPlaces += car.getSize();
            return true;
        }
        return false;
    }

    @Override
    public Car leaveParking(String carNumber) {
        Car rsl = null;
        if (carMap.containsKey(carNumber)) {
            occupiedPlaces -= 2;
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
