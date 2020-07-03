package ru.job4j.lsp.car_parking;

public class TruckParking implements Parking {
    private int parkingPlaces;

    public TruckParking(int parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    @Override
    public void park(Car car) {

    }

    @Override
    public void leaveParking(Car car) {

    }

    @Override
    public boolean checkFreePlaces() {
        return false;
    }
}
