// ParkEase – Smart Parking Management System
// Fresher-friendly implementation with clear comments
// All classes are written in one file for easy understanding

import java.util.*;

// Interface for payment calculation
interface IPayable {
    double calculateCharges(int hours);
}

// Base Vehicle Class
class Vehicle {
    protected String vehicleNumber;
    protected String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}

// Subclasses for different vehicle types
class Car extends Vehicle {
    public Car(String number) {
        super(number, "CAR");
    }
}

class Bike extends Vehicle {
    public Bike(String number) {
        super(number, "BIKE");
    }
}

class Truck extends Vehicle {
    public Truck(String number) {
        super(number, "TRUCK");
    }
}

// ParkingSlot class storing slot data
class ParkingSlot {

    private String slotId;
    private boolean isOccupied;              // Encapsulation: cannot be changed directly
    private String vehicleTypeAllowed;
    private String location;

    // Constructor for slot initialization
    public ParkingSlot(String slotId, String location, String vehicleTypeAllowed) {
        this.slotId = slotId;
        this.location = location;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.isOccupied = false;             // default: available
    }

    // Getter for slot availability
    public boolean isAvailable() {
        return !isOccupied;
    }

    // Method to occupy slot (encapsulated)
    public void occupy() {
        isOccupied = true;
    }

    // Method to free slot (encapsulated)
    public void free() {
        isOccupied = false;
    }

    public String getVehicleTypeAllowed() {
        return vehicleTypeAllowed;
    }

    public String getSlotId() {
        return slotId;
    }
}

// Parking Charge Logic – Polymorphism
class CarCharge implements IPayable {
    @Override
    public double calculateCharges(int hours) {
        int baseRate = 30;
        double amount = baseRate * hours;
        if (hours > 5) {
            amount += 50;      // Penalty if over time
        }
        return amount;
    }
}

class BikeCharge implements IPayable {
    @Override
    public double calculateCharges(int hours) {
        int baseRate = 15;
        double amount = baseRate * hours;
        if (hours > 4) {
            amount += 20;
        }
        return amount;
    }
}

class TruckCharge implements IPayable {
    @Override
    public double calculateCharges(int hours) {
        int baseRate = 50;
        double amount = baseRate * hours;
        if (hours > 3) {
            amount += 100;
        }
        return amount;
    }
}

// ParkingManager to handle records
class ParkingManager {

    private List<String> bookingRecords = new ArrayList<>();     // Access-modifier protected, only logs exposed
    private List<ParkingSlot> slots = new ArrayList<>();

    // Add slots to system
    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    // Assign slot to a vehicle if available
    public ParkingSlot assignSlot(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable() && slot.getVehicleTypeAllowed().equals(vehicle.vehicleType)) {
                slot.occupy();
                recordBooking(vehicle.vehicleNumber, slot.getSlotId());
                return slot;
            }
        }
        return null;
    }

    // Internal private booking records
    private void recordBooking(String vehicleNumber, String slotId) {
        bookingRecords.add("Vehicle " + vehicleNumber + " booked Slot " + slotId);
    }

    // Only exposed logs (read-only)
    public void showLogs() {
        System.out.println("\n--- Booking Logs ---");
        for (String log : bookingRecords) {
            System.out.println(log);
        }
    }
}

// Main Application Class
public class ParkEaseApp {

    public static void main(String[] args) {

        // Create Parking Manager
        ParkingManager manager = new ParkingManager();

        // Create parking slots
        manager.addSlot(new ParkingSlot("S1", "North Zone", "CAR"));
        manager.addSlot(new ParkingSlot("S2", "East Zone", "BIKE"));
        manager.addSlot(new ParkingSlot("S3", "West Zone", "TRUCK"));

        // Create vehicles
        Car c1 = new Car("MP04-C1234");
        Bike b1 = new Bike("MP04-B5678");
        Truck t1 = new Truck("MP04-T9999");

        // Assign slots
        ParkingSlot slotCar = manager.assignSlot(c1);
        ParkingSlot slotBike = manager.assignSlot(b1);
        ParkingSlot slotTruck = manager.assignSlot(t1);

        System.out.println("Assigned Slot to Car: " + (slotCar != null ? slotCar.getSlotId() : "No Slot"));
        System.out.println("Assigned Slot to Bike: " + (slotBike != null ? slotBike.getSlotId() : "No Slot"));
        System.out.println("Assigned Slot to Truck: " + (slotTruck != null ? slotTruck.getSlotId() : "No Slot"));

        // Calculate charges
        IPayable carPay = new CarCharge();
        IPayable bikePay = new BikeCharge();
        IPayable truckPay = new TruckCharge();

        System.out.println("\nParking Charges:");
        System.out.println("Car (6 hours): " + carPay.calculateCharges(6));
        System.out.println("Bike (5 hours): " + bikePay.calculateCharges(5));
        System.out.println("Truck (4 hours): " + truckPay.calculateCharges(4));

        // Show booking logs
        manager.showLogs();
    }
}
