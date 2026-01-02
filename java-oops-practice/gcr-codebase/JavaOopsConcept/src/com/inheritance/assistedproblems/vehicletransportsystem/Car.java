package com.inheritance.assistedproblems.vehicletransportsystem;
class Car extends Vehicle {

    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type : Car");
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}