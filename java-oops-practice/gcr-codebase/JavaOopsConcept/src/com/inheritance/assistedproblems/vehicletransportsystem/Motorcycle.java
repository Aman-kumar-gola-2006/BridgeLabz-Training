package com.inheritance.assistedproblems.vehicletransportsystem;

class Motorcycle extends Vehicle {

    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type : Motorcycle");
        System.out.println("Has Gear     : " + hasGear);
    }
}