package ru.job4j.lsp.car_parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CarParkingTest {

    @Test
    public void whenParkTwoCars() {
        CarParking carParking = new CarParking(3,2);
        Car tr1 = new Truck("tr1", "trn1", 2);
        Car cr1 = new PassengerCar("cr1", "crn1", 1);
        carParking.park(tr1);
        carParking.park(cr1);
        assertThat(2, is(carParking.getCars().size()));
    }

    @Test
    public void whenThereAreNotFreePlace() {
        CarParking carParking = new CarParking(1,2);
        Car tr1 = new Truck("tr1", "trn1", 2);
        Car cr1 = new PassengerCar("cr1", "crn1", 1);
        Car cr2 = new PassengerCar("cr2", "crn2", 1);
        carParking.park(tr1);
        carParking.park(cr1);
        assertFalse(carParking.park(cr2));
    }

    @Test
    public void whenCarLeaveParking() {
        CarParking carParking = new CarParking(1,2);
        Car tr1 = new Truck("tr1", "trn1", 2);
        Car cr1 = new PassengerCar("cr1", "crn1", 1);
        carParking.park(tr1);
        carParking.park(cr1);
        assertThat(tr1, is(carParking.leaveParking("trn1")));
        assertThat(1, is(carParking.getCars().size()));
    }
}