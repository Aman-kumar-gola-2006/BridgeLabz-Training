// TourMate – Travel Itinerary Planner
// Fully beginner-friendly code, all classes in one file, user input supported

import java.util.*;

// Interface for booking functionality
interface IBookable {
    void book();
    void cancel();
}

// Base Trip Class
class Trip implements IBookable {

    protected String destination;
    protected double budget;
    protected int duration;       // in days

    // Associated services
    protected Transport transport;
    protected Hotel hotel;
    protected Activity activity;

    // Constructor to create a trip package
    public Trip(String destination, double budget, int duration,
                Transport transport, Hotel hotel, Activity activity) {
        this.destination = destination;
        this.budget = budget;
        this.duration = duration;
        this.transport = transport;
        this.hotel = hotel;
        this.activity = activity;
    }

    // Private cost breakdown (Encapsulation)
    private double calculateTotal() {
        // operator use → hotel + transport + activities
        return hotel.getCost() + transport.getCost() + activity.getCost();
    }

    public double getTotalCost() {
        return calculateTotal();
    }

    // Default booking logic
    @Override
    public void book() {
        System.out.println("Booking a standard trip to " + destination);
    }

    @Override
    public void cancel() {
        System.out.println("Trip to " + destination + " cancelled.");
    }
}

// Subclass for Domestic Trip
class DomesticTrip extends Trip {

    public DomesticTrip(String destination, double budget, int duration,
                        Transport transport, Hotel hotel, Activity activity) {
        super(destination, budget, duration, transport, hotel, activity);
    }

    @Override
    public void book() {
        System.out.println("Booking Domestic Trip...");
        System.out.println("Destination: " + destination);
    }
}

// Subclass for International Trip
class InternationalTrip extends Trip {

    public InternationalTrip(String destination, double budget, int duration,
                             Transport transport, Hotel hotel, Activity activity) {
        super(destination, budget, duration, transport, hotel, activity);
    }

    @Override
    public void book() {
        System.out.println("Booking International Trip with passport verification...");
        System.out.println("Destination: " + destination);
    }
}

// Transport Class
class Transport {

    private double cost;    // Hidden cost breakdown

    public Transport(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}

// Hotel Class
class Hotel {

    private double cost;

    public Hotel(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}

// Activity Class
class Activity {

    private double cost;

    public Activity(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}

// Main Application Class
public class TourMateApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== TourMate – Travel Itinerary Planner ===");

        // Input from user
        System.out.print("Enter Trip Type (domestic/international): ");
        String type = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter Budget: ");
        double budget = sc.nextDouble();

        System.out.print("Enter Trip Duration (days): ");
        int days = sc.nextInt();

        System.out.print("Enter Transport Cost: ");
        double tCost = sc.nextDouble();

        System.out.print("Enter Hotel Cost: ");
        double hCost = sc.nextDouble();

        System.out.print("Enter Activity Cost: ");
        double aCost = sc.nextDouble();

        // Creating service objects
        Transport transport = new Transport(tCost);
        Hotel hotel = new Hotel(hCost);
        Activity activity = new Activity(aCost);

        Trip trip = null;

        // Creating trip object based on type (Inheritance + Polymorphism)
        if (type.equalsIgnoreCase("domestic")) {
            trip = new DomesticTrip(destination, budget, days, transport, hotel, activity);
        } else if (type.equalsIgnoreCase("international")) {
            trip = new InternationalTrip(destination, budget, days, transport, hotel, activity);
        } else {
            System.out.println("Invalid trip type!");
            sc.close();
            return;
        }

        // Booking trip
        trip.book();

        // Display total trip cost
        System.out.println("\nTotal Package Cost: " + trip.getTotalCost());

        // Compare budget
        if (trip.getTotalCost() > budget) {
            System.out.println("Warning: Trip exceeds your budget!");
        } else {
            System.out.println("Trip is within your budget.");
        }

        // Cancel option
        System.out.print("\nDo you want to cancel the trip? (yes/no): ");
        sc.nextLine();  // clear buffer
        String cancel = sc.nextLine();

        if (cancel.equalsIgnoreCase("yes")) {
            trip.cancel();
        } else {
            System.out.println("Trip Confirmed!");
        }

        sc.close();
    }
}
