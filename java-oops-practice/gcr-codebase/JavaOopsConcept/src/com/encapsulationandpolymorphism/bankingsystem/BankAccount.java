package com.encapsulationandpolymorphism.bankingsystem;

/*
 * Abstract BankAccount class
 * --------------------------
 * Acts as a base class for all bank accounts.
 * Demonstrates encapsulation and abstraction.
 */
public abstract class BankAccount {

    // Encapsulated account details
    private String accountNumber;
    private String holderName;
    protected double balance;

    // Constructor initializes common account data
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Controlled access using getters
    public String getAccountNumber() {
        return "XXXXXX" + accountNumber.substring(accountNumber.length() - 4);
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit money safely
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful. Amount: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money with balance check
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful. Amount: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    /*
     * Abstract method for interest calculation.
     * Implemented differently by each account type.
     */
    public abstract double calculateInterest();

    // Displays common account details
    public void displayAccountDetails() {
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Account Holder : " + holderName);
        System.out.println("Balance        : ₹" + balance);
    }
}

