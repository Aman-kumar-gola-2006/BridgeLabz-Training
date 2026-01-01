package com.objectmodeling;

public class Customer {
     
	 private String name;
	    private double balance;

	    // Constructor
	    public Customer(String name) {
	        this.name = name;
	        this.balance = 0.0;
	    }

	    // Method to deposit money
	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println(amount + " deposited successfully.");
	    }

	    // Method to view balance
	    public void viewBalance() {
	        System.out.println("Customer: " + name);
	        System.out.println("Current Balance: ₹" + balance);
	    }

	    // Getter for balance
	    public double getBalance() {
	        return balance;
	    }

	    // Setter for balance
	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

	    // Getter for name
	    public String getName() {
	        return name;
	    }
}