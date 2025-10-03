package com.mycompany.carrentalsystem;
    

//RentalAgency.java
//Represents a car rental agency.
//This class manages collections of cars and customers and provides the business logic for renting cars
//

/**
 * Responsibilities include:
 * -Storing and managing cars
 * -Storing and managing customers
 * -Handle renting operations between the customers and cars
 * 
 * 
 * Author: DEDAN MUGAMBI
 * Date: October 2025
 */

import com.mycompany.carrentalsystem.Customer;
import java.util.ArrayList;
import java.util.List;

class RentalAgency {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    public List<Car> getCars() { return cars; }

    public void addCar(Car car) { cars.add(car); }
    public void addCustomer(Customer customer) { customers.add(customer); }

    public void rentCar(String customerId, String licensePlate) {
        Customer customer = findCustomer(customerId);
        Car car = findCar(licensePlate);
        if (customer != null && car != null && car.isAvailable()) {
            customer.rentCar(car);
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Rental failed: Invalid customer/car or car unavailable.");
        }
    }

    private Customer findCustomer(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(id)) return c;
        }
        return null;
    }

    private Car findCar(String plate) {
        for (Car c : cars) {
            if (c.getLicensePlate().equals(plate)) return c;
        }
        return null;
    }
}