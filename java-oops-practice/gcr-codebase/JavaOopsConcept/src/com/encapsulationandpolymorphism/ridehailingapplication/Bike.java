package com.encapsulationandpolymorphism.ridehailingapplication;

/*
 * Bike class
 * ----------
 * Bikes are the most economical option.
 */
public class Bike extends Vehicle implements GPS {

    private String location = "Unknown";

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    // No extra charges
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
