package ru.job4j.lsp.car_parking;


import java.util.HashMap;
import java.util.Map;

public class BaseParking {
    private TruckParking truckParking;
    private PassengerCarParking pasCarParking;

    public BaseParking(TruckParking truckParking, PassengerCarParking pasCarParking) {
        this.truckParking = truckParking;
        this.pasCarParking = pasCarParking;
    }

    public void addCar(Car car) {
        if (!truckParking.park(car)) {
            if (!pasCarParking.park(car)) {
                System.out.println("нет мест на парковке");
            }
        }
    }

    public void removeCar(String number) {
        if (pasCarParking.leaveParking(number) == null) {
            truckParking.leaveParking(number);
        }
    }

    public Map<String, Car> getAllCars() {
        Map<String, Car> rsl = new HashMap<>();
        rsl.putAll(truckParking.getCars());
        rsl.putAll(pasCarParking.getCars());
        return rsl;
    }
}
