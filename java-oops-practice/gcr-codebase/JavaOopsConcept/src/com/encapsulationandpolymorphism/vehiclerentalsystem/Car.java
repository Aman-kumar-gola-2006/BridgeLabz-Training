package com.encapsulationandpolymorphism.vehiclerentalsystem;

/*
 * Car class
 * ---------
 * Cars have moderate rental and insurance costs.
 */
public class Car extends Vehicle implements Insurable {

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }

    // Rental cost with 5% service charge
    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) * 1.05;
    }

    // Insurance is 8% of base rental rate
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.08;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Insurance Type : Comprehensive (8%)");
    }
}

