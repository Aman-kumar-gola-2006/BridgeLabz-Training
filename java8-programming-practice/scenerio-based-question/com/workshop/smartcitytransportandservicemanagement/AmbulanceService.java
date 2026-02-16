package com.workshop.smartcitytransportandservicemanagement;

public class AmbulanceService implements TransportService, EmergencyService {
	public String getServiceName() {
		return "Ambulance";
	}

	public String getRoute() {
		return "Emergency Route";
	}

	public double getFare() {
		return 0;
	}

	public int getPassengers() {
		return 1;
	}
}
