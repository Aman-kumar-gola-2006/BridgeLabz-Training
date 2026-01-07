// EventEase – Event Management Platform
// All classes are inside one file for fresher-friendly understanding

import java.util.*;

// Interface (Polymorphism): Different event types implement schedule(), reschedule(), cancel()
interface ISchedulable {
    void schedule();
    void reschedule(String newDate);
    void cancel();
}

// User class to represent organizer (Encapsulation for sensitive data)
class User {
    private String name;
    private String contact;

    public User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}

// Parent Class: Event (Base class)
class Event implements ISchedulable {

    private final int eventId;               // Cannot be edited after assigned (access modifier concept)
    protected String eventName;
    protected String location;
    protected String date;
    protected int attendees;

    // Encapsulated pricing variables
    protected double venueCost;
    protected double serviceCost;
    protected double discount;

    protected User organizer;                // User object for event organizer

    // Constructor without services (basic event)
    public Event(int eventId, String eventName, String location, String date, int attendees, User organizer) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;

        this.venueCost = 10000;    // default venue price
        this.serviceCost = 0;      // no catering/decoration
        this.discount = 0;
    }

    // Constructor with services (catering/decoration)
    public Event(int eventId, String eventName, String location, String date, int attendees,
                 double serviceCost, double discount, User organizer) {

        this(eventId, eventName, location, date, attendees, organizer);
        this.serviceCost = serviceCost;
        this.discount = discount;
    }

    // Method to calculate total cost using operators
    public double calculateTotalCost() {
        return (venueCost + serviceCost - discount);
    }

    public int getEventId() {
        return eventId;  // Only getter to protect eventId
    }

    // Default schedule() - overridden in child classes
    @Override
    public void schedule() {
        System.out.println("Event scheduled on: " + date);
    }

    @Override
    public void reschedule(String newDate) {
        System.out.println("Event rescheduled from " + date + " to " + newDate);
        this.date = newDate;
    }

    @Override
    public void cancel() {
        System.out.println("Event cancelled: " + eventName);
    }

    // Display full event summary
    public void showEventDetails() {
        System.out.println("\n----- EVENT DETAILS -----");
        System.out.println("Event ID: " + eventId);
        System.out.println("Name: " + eventName);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Attendees: " + attendees);
        System.out.println("Organizer: " + organizer.getName() + " | Contact: " + organizer.getContact());
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

// Child Class 1: Birthday Event
class BirthdayEvent extends Event {

    public BirthdayEvent(int id, String name, String location, String date, int attendees,
                         double serviceCost, double discount, User organizer) {
        super(id, name, location, date, attendees, serviceCost, discount, organizer);
    }

    // Polymorphism: Birthday event schedule behavior
    @Override
    public void schedule() {
        System.out.println("Birthday Party scheduled at " + location + " on " + date);
    }
}

// Child Class 2: Conference Event
class ConferenceEvent extends Event {

    public ConferenceEvent(int id, String name, String location, String date, int attendees,
                           double serviceCost, double discount, User organizer) {
        super(id, name, location, date, attendees, serviceCost, discount, organizer);
    }

    // Polymorphism: Conference event schedule behavior
    @Override
    public void schedule() {
        System.out.println("Conference scheduled at " + location + " with " + attendees + " attendees.");
    }
}

// Main class to test the system
public class EventEaseApp {
    public static void main(String[] args) {

        // Creating organizer (User)
        User organizer = new User("Aman", "9876543210");

        // Creating Birthday Event object
        BirthdayEvent bEvent = new BirthdayEvent(
                101, "Aman's Birthday", "Agra", "25-01-2026", 50,
                5000, 1000, organizer
        );

        // Creating Conference Event object
        ConferenceEvent cEvent = new ConferenceEvent(
                202, "Tech Conference", "Delhi", "10-02-2026", 200,
                15000, 2000, organizer
        );

        // Testing schedule operations
        bEvent.schedule();
        bEvent.reschedule("26-01-2026");
        bEvent.showEventDetails();

        System.out.println("\n------------------------------------\n");

        cEvent.schedule();
        cEvent.cancel();
        cEvent.showEventDetails();
    }
}
