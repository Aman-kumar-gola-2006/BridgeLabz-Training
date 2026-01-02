package com.inheritance.hybridinheritance.vehiclemanagementsystem;

public class Main {
public static void main(String[] args) {
	System.out.println("-------------------");

    // -------- Vehicle Management System --------
    ElectricVehicle ev = new ElectricVehicle(160, "Tesla");
    PetrolVehicle pv = new PetrolVehicle(180, "Honda");

    ev.charge();
    pv.refuel();
}
}