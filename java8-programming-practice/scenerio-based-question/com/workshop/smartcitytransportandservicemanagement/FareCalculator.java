package com.workshop.smartcitytransportandservicemanagement;

@FunctionalInterface
public interface FareCalculator {
	double calculateFare(double distanceKm);
}
