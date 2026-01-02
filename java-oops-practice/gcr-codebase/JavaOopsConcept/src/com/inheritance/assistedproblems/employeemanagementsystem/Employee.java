package com.inheritance.assistedproblems.employeemanagementsystem;

public class Employee {

	  String name;
	    int id;
	    double salary;

	    // Constructor to initialize common employee details
	    public Employee(String name, int id, double salary) {
	        this.name = name;
	        this.id = id;
	        this.salary = salary;
	    }

	    // Method to display employee details
	    public void displayDetails() {
	        System.out.println("Employee Name: " + name);
	        System.out.println("Employee ID: " + id);
	        System.out.println("Salary: " + salary);
	    }
	}