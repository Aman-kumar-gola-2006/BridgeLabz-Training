package com.workshop.smartcitytransportandservicemanagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SmartCityDashboard {
	public static void main(String[] args) {
		List<TransportService> services = new ArrayList<>();

		// Metro Services
		services.add(new MetroService("Central Station → Airport", 60.0, 200));
		services.add(new MetroService("City Mall → Tech Park", 45.0, 180));
		services.add(new MetroService("North Zone → South Zone", 55.0, 220));

		// Taxi Services
		services.add(new TaxiService("Railway Station → Hotel Plaza", 180.0, 3));
		services.add(new TaxiService("IT Hub → Downtown", 150.0, 2));
		services.add(new TaxiService("Airport → City Center", 320.0, 4));
		services.add(new TaxiService("University → Hostel", 90.0, 1));

		// Bus Services
		services.add(new BusService("Bus Stand → Industrial Area", 30.0, 40));
		services.add(new BusService("Old City → New City", 35.0, 45));
		services.add(new BusService("Main Market → Residential Block", 25.0, 38));

		// Ambulance Services
		services.add(new AmbulanceService());
		services.add(new AmbulanceService());
		services.add(new AmbulanceService());

		// Additional Mixed Services
		services.add(new TaxiService("Shopping Mall → Home", 120.0, 2));
		services.add(new BusService("Metro Station → College", 20.0, 50));

		System.out.println("==============================================");
		System.out.println("LIVE TRANSPORT DASHBOARD");

		// forEach() + Method Reference
		services.forEach(TransportService::printServiceDetails);

		// Lambda – filter & sort by fare
		System.out.println("Sorted by Lowest Fare:");
		services.stream().filter(s -> s.getFare() > 0).sorted(Comparator.comparingDouble(TransportService::getFare))
				.forEach(TransportService::printServiceDetails);

		System.out.println("==============================================");

		// Functional Interface – Fare Calculator
		FareCalculator taxiFare = distance -> distance * 15;
		double distance = Geoutils.calculateDistance(18.5, 73.9, 18.6, 74.0);

		System.out.println("Taxi Fare for distance: " + distance + " KM -> " + taxiFare.calculateFare(distance));

		System.out.println("==============================================");

		// Collectors – groupingBy route
		Map<String, List<TransportService>> byRoute = services.stream()
				.collect(Collectors.groupingBy(TransportService::getRoute));

		byRoute.forEach((route, list) -> System.out.println(route + " -> " + list.size() + " services"));

		System.out.println("==============================================");

		// partitioningBy – peak vs non-peak
		Map<Boolean, List<TransportService>> peakPartition = services.stream()
				.collect(Collectors.partitioningBy(s -> s.getPassengers() > 50));

		System.out.println("Peak Services: " + peakPartition.get(true).size());
		System.out.println("Non-Peak Services: " + peakPartition.get(false).size());

		System.out.println("==============================================");

		// summarizingDouble – revenue summary
		DoubleSummaryStatistics revenueStats = services.stream()
				.collect(Collectors.summarizingDouble(s -> s.getFare() * s.getPassengers()));

		System.out.println("Total Revenue: " + revenueStats.getSum());
		System.out.println("Average Revenue: " + revenueStats.getAverage());

		System.out.println("==============================================");

		// Marker Interface Detection
		System.out.println("Emergency Services:");
		services.stream().filter(s -> s instanceof EmergencyService).forEach(TransportService::printServiceDetails);
	}
}
