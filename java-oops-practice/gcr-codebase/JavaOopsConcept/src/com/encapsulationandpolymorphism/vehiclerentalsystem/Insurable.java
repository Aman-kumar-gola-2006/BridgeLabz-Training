package com.encapsulationandpolymorphism.vehiclerentalsystem;


/*
 * Insurable interface
 * -------------------
 * Vehicles that require insurance must implement this interface.
 * It ensures consistent insurance calculation behavior.
 */
public interface Insurable {

    // Calculates insurance cost
    double calculateInsurance();

    // Displays insurance-related information
    void getInsuranceDetails();
}

