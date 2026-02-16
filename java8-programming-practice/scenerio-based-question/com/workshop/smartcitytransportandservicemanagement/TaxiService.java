package com.workshop.smartcitytransportandservicemanagement;

public class TaxiService implements TransportService {
	private String route;
	private double fare;
	private int passengers;

	public TaxiService(String route, double fare, int passengers) {
		this.route = route;
		this.fare = fare;
		this.passengers = passengers;
	}

	public String getServiceName() {
		return "Taxi";
	}

	public String getRoute() {
		return route;
	}

	public double getFare() {
		return fare;
	}

	public int getPassengers() {
		return passengers;
	}
}
