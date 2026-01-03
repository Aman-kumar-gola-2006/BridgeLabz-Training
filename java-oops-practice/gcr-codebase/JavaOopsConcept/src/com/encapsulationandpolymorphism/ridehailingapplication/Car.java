package com.encapsulationandpolymorphism.ridehailingapplication;

/*
 * Car class
 * ---------
 * Cars have higher comfort charges.
 */
public class Car extends Vehicle implements GPS {

    private String location = "Unknown";

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    // Includes 20% comfort charge
    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) * 1.20;
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
