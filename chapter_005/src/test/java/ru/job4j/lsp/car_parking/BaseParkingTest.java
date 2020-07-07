package ru.job4j.lsp.car_parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BaseParkingTest {

    @Test
    public void addCar() {
        PassengerCarParking pasPark = new PassengerCarParking(1);
        TruckParking truckPark = new TruckParking(1);
        Car tr1 = new Truck("tr1", "trn1", 2);
        BaseParking baseParking = new BaseParking(truckPark, pasPark);
        baseParking.addCar(tr1);
        assertThat(tr1, is(baseParking.getAllCars().get("trn1")));
    }

    @Test
    public void removeCar() {
        PassengerCarParking pasPark = new PassengerCarParking(1);
        TruckParking truckPark = new TruckParking(1);
        Car tr1 = new Truck("tr1", "trn1", 2);
        BaseParking baseParking = new BaseParking(truckPark, pasPark);
        baseParking.addCar(tr1);
        baseParking.removeCar("trn1");
        assertThat(0, is(baseParking.getAllCars().size()));
    }

    @Test
    public void addTruckToPassengerCarParking() {
        PassengerCarParking pasPark = new PassengerCarParking(2);
        TruckParking truckPark = new TruckParking(0);
        Car tr1 = new Truck("tr1", "trn1", 2);
        BaseParking baseParking = new BaseParking(truckPark, pasPark);
        baseParking.addCar(tr1);
        assertThat(tr1, is(baseParking.getAllCars().get("trn1")));
    }

    @Test
    public void whenThereAreNotEnoughPlaces() {
        PassengerCarParking pasPark = new PassengerCarParking(1);
        TruckParking truckPark = new TruckParking(0);
        Car tr1 = new Truck("tr1", "trn1", 2);
        BaseParking baseParking = new BaseParking(truckPark, pasPark);
        baseParking.addCar(tr1);
        assertThat(0, is(baseParking.getAllCars().size()));
    }
}