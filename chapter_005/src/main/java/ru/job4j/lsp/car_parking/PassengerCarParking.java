package ru.job4j.lsp.car_parking;

public class PassengerCarParking implements Parking {

    private int parkingPlaces;

    public PassengerCarParking(int parkingPlaces) {
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
