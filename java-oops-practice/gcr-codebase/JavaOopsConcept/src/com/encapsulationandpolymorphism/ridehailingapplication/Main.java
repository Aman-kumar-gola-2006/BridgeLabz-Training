package com.encapsulationandpolymorphism.ridehailingapplication;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism by calculating fares
 * for different vehicle types dynamically.
 */
public class Main {

    // Polymorphic fare calculation method
    public static void calculateRideFares(List<Vehicle> vehicles, double distance) {

        System.out.println("\n========== RIDE FARE SUMMARY ==========\n");

        for (Vehicle vehicle : vehicles) {

            vehicle.getVehicleDetails();

            double fare = vehicle.calculateFare(distance);
            System.out.println("Ride Distance : " + distance + " km");
            System.out.println("Total Fare    : ₹" + fare);

            // GPS details if supported
            if (vehicle instanceof GPS gpsVehicle) {
                System.out.println("Current Location: " + gpsVehicle.getCurrentLocation());
            }

            System.out.println("--------------------------------------\n");
        }
    }

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        // -------- Cars (3 examples) --------
        Car car1 = new Car("CAR123", "Ramesh", 15);
        car1.updateLocation("MG Road");

        Car car2 = new Car("CAR456", "Suresh", 18);
        car2.updateLocation("Airport");

        Car car3 = new Car("CAR789", "Mahesh", 20);
        car3.updateLocation("Railway Station");

        // -------- Bikes (3 examples) --------
        Bike bike1 = new Bike("BIK111", "Amit", 8);
        bike1.updateLocation("City Mall");

        Bike bike2 = new Bike("BIK222", "Rohit", 7);
        bike2.updateLocation("Tech Park");

        Bike bike3 = new Bike("BIK333", "Kunal", 9);
        bike3.updateLocation("Bus Stand");

        // -------- Autos (3 examples) --------
        Auto auto1 = new Auto("AUT999", "Shyam", 12);
        auto1.updateLocation("Market Area");

        Auto auto2 = new Auto("AUT888", "Mohan", 11);
        auto2.updateLocation("Hospital");

        Auto auto3 = new Auto("AUT777", "Raju", 13);
        auto3.updateLocation("College Gate");

        // Add all vehicles
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);
        vehicles.add(bike1);
        vehicles.add(bike2);
        vehicles.add(bike3);
        vehicles.add(auto1);
        vehicles.add(auto2);
        vehicles.add(auto3);

        // Calculate fares for a 10 km ride
        calculateRideFares(vehicles, 10);
    }
}

