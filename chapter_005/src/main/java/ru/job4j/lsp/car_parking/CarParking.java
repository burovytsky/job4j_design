package ru.job4j.lsp.car_parking;

import java.util.HashMap;
import java.util.Map;

public class CarParking implements Parking {
    private Map<String, Car> carMap = new HashMap<>();
    private int sumPlaces;

    public CarParking(int autoCount, int truckCount) {
        this.sumPlaces = autoCount + truckCount;
    }

    @Override
    public boolean park(Car car) {
        if (checkFreePlaces(car)) {
            carMap.put(car.getNumber(), car);
            sumPlaces -= car.getSize();
            return true;
        }
        System.out.println("Mest net");
        return false;
    }

    @Override
    public Car leaveParking(String carNumber) {
        Car rsl = null;
        if (carMap.containsKey(carNumber)) {
            rsl = carMap.remove(carNumber);
            sumPlaces -= rsl.getSize();
        }
        return rsl;
    }

    @Override
    public boolean checkFreePlaces(Car car) {
        return sumPlaces >= car.getSize();
    }

    @Override
    public Map<String, Car> getCars() {
        return carMap;
    }

}
