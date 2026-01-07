// FitTrack – Your Personal Fitness Tracker
// Simple fresher-level Java program using OOP concepts only

import java.util.*;

// ---------------- INTERFACE ----------------
// Interface for tracking workouts
interface ITrackable {
    void startWorkout();
    void stopWorkout();
}

// ---------------- USER PROFILE CLASS ----------------
class UserProfile {
    public String name;
    public int age;

    // private health data (encapsulation)
    private double weight;

    public String goal;

    // Constructor with default goal
    UserProfile(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = "Stay Fit";
    }

    // Constructor with custom goal
    UserProfile(String name, int age, double weight, String goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
    }

    // Getter method to access private weight
    public double getWeight() {
        return weight;
    }
}

// ---------------- BASE WORKOUT CLASS ----------------
class Workout implements ITrackable {

    protected String type;
    protected int duration; // in minutes
    protected int caloriesBurned;

    // internal workout logs should not be exposed
    private String[] workoutLogs = {"Warm-up", "Main workout", "Cool-down"};

    Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    // Start workout
    public void startWorkout() {
        System.out.println(type + " workout started.");
    }

    // Stop workout
    public void stopWorkout() {
        System.out.println(type + " workout stopped.");
    }

    // Polymorphic method
    public int calculateCalories() {
        return 0;
    }

    // Method to show summary (logs remain private)
    public void showWorkoutSummary() {
        System.out.println("Workout Type: " + type);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories Burned: " + caloriesBurned);
    }
}

// ---------------- CARDIO WORKOUT ----------------
class CardioWorkout extends Workout {

    CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    // Different calorie calculation logic
    public int calculateCalories() {
        // simple brute-force logic
        caloriesBurned = duration * 8;
        return caloriesBurned;
    }
}

// ---------------- STRENGTH WORKOUT ----------------
class StrengthWorkout extends Workout {

    StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    // Different calorie calculation logic
    public int calculateCalories() {
        caloriesBurned = duration * 6;
        return caloriesBurned;
    }
}

// ---------------- MAIN CLASS ----------------
public class FitTrackSystem {

    public static void main(String[] args) {

        // Create user profile
        UserProfile user = new UserProfile(
                "Aman",
                21,
                68.5,
                "Lose Weight"
        );

        // Daily calorie target
        int dailyTarget = 500;

        // Create workout objects
        Workout cardio = new CardioWorkout(30);
        Workout strength = new StrengthWorkout(20);

        // Start cardio workout
        cardio.startWorkout();
        int cardioCalories = cardio.calculateCalories();
        cardio.stopWorkout();

        // Start strength workout
        strength.startWorkout();
        int strengthCalories = strength.calculateCalories();
        strength.stopWorkout();

        // Total calories burned
        int totalCaloriesBurned = cardioCalories + strengthCalories;

        // Operator usage for progress calculation
        int remainingCalories = dailyTarget - totalCaloriesBurned;

        // Display results
        System.out.println("\n--- DAILY FITNESS REPORT ---");
        System.out.println("User: " + user.name);
        System.out.println("Goal: " + user.goal);

        cardio.showWorkoutSummary();
        strength.showWorkoutSummary();

        System.out.println("Daily Target: " + dailyTarget);
        System.out.println("Total Calories Burned: " + totalCaloriesBurned);
        System.out.println("Remaining Calories to Burn: " + remainingCalories);
    }
}
