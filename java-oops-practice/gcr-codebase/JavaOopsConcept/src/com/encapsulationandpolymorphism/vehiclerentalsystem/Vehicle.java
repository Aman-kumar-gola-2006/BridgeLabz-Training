package com.encapsulationandpolymorphism.vehiclerentalsystem;

/*
 * Abstract Vehicle class
 * ----------------------
 * Acts as a base class for all vehicle types.
 * Uses encapsulation to protect sensitive details.
 */
public abstract class Vehicle {

    // Encapsulated fields
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Sensitive information (restricted access)
    private String insurancePolicyNumber;

    // Constructor initializes common vehicle data
    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // Read-only access using getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Controlled setter for rental rate
    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) {
            this.rentalRate = rentalRate;
        }
    }

    // Insurance policy number is protected and never directly exposed
    protected String getMaskedPolicyNumber() {
        return "XXXX-" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    /*
     * Abstract method for rental cost calculation.
     * Each vehicle type defines its own logic.
     */
    public abstract double calculateRentalCost(int days);

    // Displays common vehicle details
    public void displayVehicleDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + type);
        System.out.println("Rental Rate    : ₹" + rentalRate + " per day");
        System.out.println("Policy Number  : " + getMaskedPolicyNumber());
    }
}

