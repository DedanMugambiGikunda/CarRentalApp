package com.mycompany.carrentalsystem;


//CarRentalApp.java
//This is the main class to run the CAR RENTAL APPLICATION
//This hadnles the user login alongside the menu interactions

//It handles user login with username and password and provides a console based meny for interaction with the system

/**Features
 * 
 * Secure login with limited attempts
 * Renting a car for a customer
 * Exit the application
 * 
 * Author: DEDAN MUGAMBI
 * Date: October 2025
 */


import java.io.IOException;
import java.util.Scanner;

public class CarRentalApp {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        int attempts = 3;

        while (attempts > 0 && !loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = readPassword();

            if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                attempts--;
                System.out.println("Incorrect username or password. " + attempts + " attempts remaining.");
            }
        }

        if (!loggedIn) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        // Initializes agency
        RentalAgency agency = new RentalAgency();
        agency.addCar(new Car("Toyota Probox", 2008, 50.0, "111222"));
        agency.addCustomer(new Customer("Dedan Mugambi", "C001"));

        //The Menu loop
        while (true) {
            System.out.println("1. View Available Cars\n2. Rent Car\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Available Cars:");
                    for (Car c : agency.getCars()) {
                        if (c.isAvailable()) System.out.println(c);
                    }
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    String custId = scanner.nextLine();
                    System.out.print("Enter license plate: ");
                    String plate = scanner.nextLine();
                    agency.rentCar(custId, plate);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

//It reads the password from the input and asterisk masks it
    private static String readPassword() {
        StringBuilder password = new StringBuilder();
        try {
            while (true) {
                char c = (char) System.in.read();
                if (c == '\r' || c == '\n') {
                    break;
                }
                password.append(c);
                System.out.print("*");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password.toString();
    }
}