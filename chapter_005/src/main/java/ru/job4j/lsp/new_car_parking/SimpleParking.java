package ru.job4j.lsp.new_car_parking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SimpleParking implements Parking {
    private final int CAR_SIZE = 1;
    List<Vehicle> cars = new ArrayList<>();
    List<Vehicle> trucks = new ArrayList<>();
    private final int carPlaces;
    private final int truckPlaces;

    public SimpleParking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        if (!checkFreePlaces(vehicle)) {
            return false;
        }
        if (vehicle.getSize() == CAR_SIZE) {
            cars.add(vehicle);

        } else if (truckPlaces - trucks.size() > 0) {
            trucks.add(vehicle);
        } else {
            for (int i = 0; i < vehicle.getSize(); i++) {
                cars.add(vehicle);
            }
        }
        return true;
    }

    @Override
    public Vehicle leaveParking(String number) {
        Vehicle vehicle = findVehicle(number);
        if (vehicle.getSize() == CAR_SIZE) {
            cars.remove(vehicle);
        } else if (cars.contains(vehicle)) {
            for (int i = 0; i < vehicle.getSize(); i++) {
                cars.remove(vehicle);
            }
        } else {
            trucks.remove(vehicle);
        }
        return vehicle;
    }

    private Vehicle findVehicle(String number) {
        Vehicle rsl = null;
        for (Vehicle vehicle : getCars()) {
            if (vehicle.getNumber().equals(number)) {
                rsl = vehicle;
            }
        }
        return rsl;
    }

    @Override
    public boolean checkFreePlaces(Vehicle vehicle) {
        if (vehicle.getSize() == CAR_SIZE && cars.size() == carPlaces) {
            return false;
        }
        return vehicle.getSize() == CAR_SIZE ||
                (trucks.size() != truckPlaces || vehicle.getSize() <= (carPlaces - cars.size()));
    }

    @Override
    public List<Vehicle> getCars() {
        Set<Vehicle> allVehicles2 = new LinkedHashSet<>();
        allVehicles2.addAll(cars);
        allVehicles2.addAll(trucks);
        return  new ArrayList<>(allVehicles2);
    }
}
