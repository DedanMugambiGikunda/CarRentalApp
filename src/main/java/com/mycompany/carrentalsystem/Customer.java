package com.mycompany.carrentalsystem;


//Customer
//Respresents a customer of the rental agency
//Each customer has a unique id, a name and can rent or return cars

/**Responsibilities
 * - Storing customer details like (name, ID)
 * - Keep track of rented cars
 * 
 * Author: DEDAN MUGAMBI
 * Date: October 2025
 */

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String customerId;
    private List<Car> rentedCars = new ArrayList<>();

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public void rentCar(Car car) {
        if (car.isAvailable()) {
            rentedCars.add(car);
            car.rent();
        }
    }

    public void returnCar(Car car) {
        if (rentedCars.remove(car)) {
            car.returnCar();
        }
    }

    public String getCustomerId() {
        return customerId;
    }
}