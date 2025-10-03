package com.mycompany.carrentalsystem;

//Car.java
//
//This represents a cat in the rental agency's inventory
//A car has attributes such as the model, year, license plate, availability status


/**
 * Responsibilities
 * -Storing car details
 * -Managing rental states 
 * -Displaying car information
 * 
 * Author: DEDAN MUGAMBI
 * Date: October 2025
 */
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int year;
    private double dailyRate;
    private boolean available;
    private String licensePlate;

    public Car(String model, int year, double dailyRate, String licensePlate) {
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.available = true;
        this.licensePlate = licensePlate;
    }

    public boolean isAvailable() { 
        return available; 
    }
    public void rent() {
        available = false; 
    }
    public void returnCar() { 
        available = true; 
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return model + " (" + year + ") - $" + dailyRate + "/day - " + (available ? "Available" : "Rented");
    }
}
