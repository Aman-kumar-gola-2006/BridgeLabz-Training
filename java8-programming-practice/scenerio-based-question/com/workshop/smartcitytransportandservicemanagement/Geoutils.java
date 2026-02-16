package com.workshop.smartcitytransportandservicemanagement;

public interface Geoutils {
	static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		return Math.sqrt(Math.pow(lat2-lat1, 2)+ Math.pow(lon2-lon1, 2))*111;
	}
}
