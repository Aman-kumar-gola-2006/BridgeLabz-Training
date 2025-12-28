package com.javaconstructors.level1;

public class BankAccount {
	// Public variable (accessible everywhere)
    public int accountNumber;

    // Protected variable (accessible in subclass)
    protected String accountHolder;

    // Private variable (data hiding)
    private double balance;

    // Constructor to initialize account details
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
