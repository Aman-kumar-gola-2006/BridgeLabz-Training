package com.inheritance.assistedproblems.employeemanagementsystem;

public class Intern extends Employee {
	  int durationMonths;

	    // Constructor for Intern
	    public Intern(String name, int id, double salary, int durationMonths) {
	        super(name, id, salary);
	        this.durationMonths = durationMonths;
	    }

	    // Overriding displayDetails method
	    @Override
	    public void displayDetails() {
	        super.displayDetails();
	        System.out.println("Internship Duration: " + durationMonths + " months");
	    }
}