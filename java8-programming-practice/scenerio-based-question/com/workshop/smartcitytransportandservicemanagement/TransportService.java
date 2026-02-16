package com.workshop.smartcitytransportandservicemanagement;

public interface TransportService {
	String getServiceName();

	String getRoute();

	double getFare();

	int getPassengers();

	default void printServiceDetails() {
		System.out.println(getServiceName() + " | Route: " + getRoute() + " | Fare: " + getFare());
	}
}
