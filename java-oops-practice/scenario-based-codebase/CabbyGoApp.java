// CabbyGo – Ride Hailing App Backend Logic
// All classes are written in a single file as requested

// Interface for Ride Service
interface IRideService {
    void bookRide(double distance);
    void endRide();
}

// Base Vehicle class (Parent Class)
class Vehicle {
    String vehicleNumber;
    int capacity;
    String type;
    double ratePerKm;   // rate depends on vehicle type

    // Constructor
    Vehicle(String vehicleNumber, int capacity, String type, double ratePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.ratePerKm = ratePerKm;
    }
}

// Mini vehicle class
class Mini extends Vehicle {
    Mini(String vehicleNumber) {
        super(vehicleNumber, 4, "Mini", 8); // simple rate
    }
}

// Sedan vehicle class
class Sedan extends Vehicle {
    Sedan(String vehicleNumber) {
        super(vehicleNumber, 4, "Sedan", 10);
    }
}

// SUV vehicle class
class SUV extends Vehicle {
    SUV(String vehicleNumber) {
        super(vehicleNumber, 6, "SUV", 15);
    }
}

// Driver class
class Driver {
    String name;
    String licenseNumber;
    private double rating; // encapsulation

    // Constructor
    Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    // Public method to read rating
    public double getRating() {
        return rating;
    }
}

// Ride class implementing interface
class Ride implements IRideService {
    private double fare;          // sensitive data hidden
    private String location;      // sensitive data hidden
    Vehicle vehicle;
    Driver driver;
    double baseFare = 50;

    // Constructor
    Ride(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    // Book ride method
    public void bookRide(double distance) {
        location = "User Location"; // hidden from outside

        // fare calculation using operators
        fare = baseFare + (distance * vehicle.ratePerKm);

        System.out.println("Ride Booked Successfully");
        System.out.println("Vehicle Type: " + vehicle.type);
        System.out.println("Vehicle Number: " + vehicle.vehicleNumber);
        System.out.println("Driver Name: " + driver.name);
        System.out.println("Driver Rating: " + driver.getRating());
        System.out.println("Estimated Fare: ₹" + fare);
    }

    // End ride method
    public void endRide() {
        System.out.println("Ride Ended");
        System.out.println("Final Fare Paid: ₹" + fare);
    }
}

// Main class
public class CabbyGoApp {
    public static void main(String[] args) {

        // Creating vehicle objects (polymorphism)
        Vehicle v1 = new Mini("MP09-AB-1234");
        Vehicle v2 = new Sedan("MP09-CD-5678");

        // Creating driver
        Driver d1 = new Driver("Ramesh", "DL12345", 4.5);

        // Booking ride
        Ride ride = new Ride(v2, d1);
        ride.bookRide(12); // distance in km
        ride.endRide();
    }
}
