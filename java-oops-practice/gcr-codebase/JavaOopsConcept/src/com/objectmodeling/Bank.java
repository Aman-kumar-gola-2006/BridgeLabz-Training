package com.objectmodeling;

public class Bank {

	 private String bankName;
	 
	public Bank(String bankName) {
		this.bankName=bankName;
	}
	public void openAccount(Customer customer, double initialDeposit) {

        System.out.println("\nOpening account at " + bankName);
        System.out.println("Customer Name: " + customer.getName());

        customer.setBalance(initialDeposit);

        System.out.println("Account opened successfully!");
        System.out.println("Initial Deposit: ₹" + initialDeposit);
    }
	 // Display bank name
    public void displayBank() {
        System.out.println("Bank Name: " + bankName);
    }
    public static void main(String[] args) {

        // Create Bank object
        Bank bank = new Bank("State Bank of India");

        // Create Customer objects
        Customer customer1 = new Customer("Rahul");
        Customer customer2 = new Customer("Sneha");

        // Bank opens accounts for customers
        bank.openAccount(customer1, 5000);
        bank.openAccount(customer2, 10000);

        // Customers interact with their accounts
        customer1.deposit(2000);
        customer1.viewBalance();

        System.out.println();

        customer2.deposit(3000);
        customer2.viewBalance();
    }
}