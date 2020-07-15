package ru.job4j.lsp.new_car_parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleParkingTest {

    @Test
    public void whenParkCarInPlaceOfCar() {
        SimpleParking simpleParking = new SimpleParking(1, 0);
        Vehicle car1 = new Car("name1", "cn1", 1);
        simpleParking.park(car1);
        assertThat(1, is(simpleParking.getCars().size()));
    }

    @Test
    public void whenParkTruckInPlaceOfCar() {
        SimpleParking simpleParking = new SimpleParking(3, 0);
        Vehicle tr2 = new Truck("name22", "tr2", 3);
        simpleParking.park(tr2);
        assertThat(1, is(simpleParking.getCars().size()));
    }

    @Test
    public void whenThereAreNotFreePlaces() {
        SimpleParking simpleParking = new SimpleParking(1, 1);
        Vehicle tr1 = new Truck("name11", "tr1", 2);
        Vehicle tr2 = new Truck("name22", "tr2", 3);
        simpleParking.park(tr1);
        assertFalse(simpleParking.park(tr2));
    }

    @Test
    public void whenVehicleLeaveParking() {
        SimpleParking simpleParking = new SimpleParking(3, 1);
        Vehicle car1 = new Car("name1", "cn1", 1);
        Vehicle tr3 = new Truck("name33", "tr3", 4);
        Vehicle tr4 = new Truck("name343", "tr43", 2);
        simpleParking.park(car1);
        simpleParking.park(tr3);
        simpleParking.park(tr4);
        assertThat(tr4, is(simpleParking.leaveParking("tr43")));
        assertThat(car1, is(simpleParking.leaveParking("cn1")));
    }
}