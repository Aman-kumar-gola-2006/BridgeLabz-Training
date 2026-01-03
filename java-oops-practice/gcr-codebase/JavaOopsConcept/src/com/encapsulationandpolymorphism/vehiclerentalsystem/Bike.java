package com.encapsulationandpolymorphism.vehiclerentalsystem;

/*
 * Bike class
 * ----------
 * Bikes have low rental cost and minimal insurance.
 */
public class Bike extends Vehicle implements Insurable {

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }

    // Simple daily rental calculation
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Insurance is 3% of rental rate
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.03;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Insurance Type : Basic (3%)");
    }
}

