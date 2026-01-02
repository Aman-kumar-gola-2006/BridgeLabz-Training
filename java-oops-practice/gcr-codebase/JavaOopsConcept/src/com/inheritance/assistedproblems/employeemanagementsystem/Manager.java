package com.inheritance.assistedproblems.employeemanagementsystem;

public class Manager extends Employee {

	 int teamSize;

	    // Constructor for Manager
	    public Manager(String name, int id, double salary, int teamSize) {
	        super(name, id, salary); // call parent constructor
	        this.teamSize = teamSize;
	    }

	    // Overriding displayDetails method
	    @Override
	    public void displayDetails() {
	        super.displayDetails();
	        System.out.println("Team Size: " + teamSize);
	    }
	}