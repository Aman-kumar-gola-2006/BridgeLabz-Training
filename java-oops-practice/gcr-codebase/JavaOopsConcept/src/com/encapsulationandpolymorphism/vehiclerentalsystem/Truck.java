package com.encapsulationandpolymorphism.vehiclerentalsystem;

/*
 * Truck class
 * -----------
 * Trucks have high rental and insurance due to heavy usage.
 */
public class Truck extends Vehicle implements Insurable {

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }

    // Rental cost includes 15% heavy-load charge
    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) * 1.15;
    }

    // Insurance is 12% of rental rate
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.12;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Insurance Type : Commercial (12%)");
    }
}

