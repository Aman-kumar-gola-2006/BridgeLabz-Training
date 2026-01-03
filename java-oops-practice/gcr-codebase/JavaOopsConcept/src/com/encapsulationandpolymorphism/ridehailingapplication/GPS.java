package com.encapsulationandpolymorphism.ridehailingapplication;

/*
 * GPS interface
 * -------------
 * Any vehicle that supports live tracking
 * must implement this interface.
 */
public interface GPS {

    // Returns the current location of the vehicle
    String getCurrentLocation();

    // Updates the vehicle's location
    void updateLocation(String newLocation);
}

