package com.encapsulationandpolymorphism.vehiclerentalsystem;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism by processing
 * all vehicles using Vehicle references.
 */
public class Main {

    // Polymorphic billing method
    public static void generateRentalSummary(List<Vehicle> vehicles, int days) {

        System.out.println("\n========== VEHICLE RENTAL SUMMARY ==========\n");

        for (Vehicle vehicle : vehicles) {

            vehicle.displayVehicleDetails();

            double insuranceCost = 0;

            // Check if vehicle is insurable
            if (vehicle instanceof Insurable insurableVehicle) {
                insurableVehicle.getInsuranceDetails();
                insuranceCost = insurableVehicle.calculateInsurance();
            }

            double rentalCost = vehicle.calculateRentalCost(days);
            double totalCost = rentalCost + insuranceCost;

            System.out.println("Rental Days   : " + days);
            System.out.println("Rental Cost  : ₹" + rentalCost);
            System.out.println("Insurance    : ₹" + insuranceCost);
            System.out.println("Total Cost   : ₹" + totalCost);
            System.out.println("-------------------------------------------\n");
        }
    }

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        // -------- Cars (3 examples) --------
        vehicles.add(new Car("MH12AB1234", 2500, "CAR987654"));
        vehicles.add(new Car("DL01XY4321", 2800, "CAR123456"));
        vehicles.add(new Car("KA05MN6789", 3000, "CAR456789"));

        // -------- Bikes (3 examples) --------
        vehicles.add(new Bike("MH14BK1111", 500, "BIKE111222"));
        vehicles.add(new Bike("DL09BK2222", 600, "BIKE333444"));
        vehicles.add(new Bike("KA03BK3333", 450, "BIKE555666"));

        // -------- Trucks (3 examples) --------
        vehicles.add(new Truck("MH20TR9999", 6000, "TRUCK999888"));
        vehicles.add(new Truck("RJ14TR8888", 6500, "TRUCK777666"));
        vehicles.add(new Truck("UP32TR7777", 7000, "TRUCK555444"));

        // Generate bill for 5 days rental
        generateRentalSummary(vehicles, 5);
    }
}
