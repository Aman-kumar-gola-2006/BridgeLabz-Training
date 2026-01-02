package com.inheritance.assistedproblems.vehicletransportsystem;

//Superclass
class Vehicle {

 int maxSpeed;
 String fuelType;

 // Constructor
 Vehicle(int maxSpeed, String fuelType) {
     this.maxSpeed = maxSpeed;
     this.fuelType = fuelType;
 }

 // Method to be overridden
 void displayInfo() {
     System.out.println("Max Speed : " + maxSpeed + " km/h");
     System.out.println("Fuel Type: " + fuelType);
 }
}