package com.encapsulationandpolymorphism.ridehailingapplication;

/*
 * Auto class
 * ----------
 * Autos have moderate pricing with small service charge.
 */
public class Auto extends Vehicle implements GPS {

    private String location = "Unknown";

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    // Includes 10% service charge
    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) * 1.10;
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

