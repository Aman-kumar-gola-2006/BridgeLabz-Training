package com.encapsulationandpolymorphism.ridehailingapplication;

/*
 * Abstract Vehicle class
 * ----------------------
 * Base class for all ride-hailing vehicles.
 * Uses encapsulation to secure sensitive data.
 */
public abstract class Vehicle {

    // Encapsulated fields
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor initializes common vehicle data
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Read-only access through getters
    public String getVehicleId() {
        return "VH-" + vehicleId.substring(vehicleId.length() - 3);
    }

    public String getDriverName() {
        return driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    // Controlled update of rate
    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm > 0) {
            this.ratePerKm = ratePerKm;
        }
    }

    /*
     * Abstract method to calculate fare.
     * Each vehicle type defines its own logic.
     */
    public abstract double calculateFare(double distance);

    // Displays basic vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID    : " + getVehicleId());
        System.out.println("Driver Name   : " + driverName);
        System.out.println("Rate per Km   : ₹" + ratePerKm);
    }
}

