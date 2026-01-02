package com.inheritance.assistedproblems.employeemanagementsystem;

public class Developer extends Employee {

	   String programmingLanguage;

	    // Constructor for Developer
	    public Developer(String name, int id, double salary, String programmingLanguage) {
	        super(name, id, salary);
	        this.programmingLanguage = programmingLanguage;
	    }

	    // Overriding displayDetails method
	    @Override
	    public void displayDetails() {
	        super.displayDetails();
	        System.out.println("Programming Language: " + programmingLanguage);
	    }
	}