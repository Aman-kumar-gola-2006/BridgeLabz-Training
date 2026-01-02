package com.inheritance.hierarchicalinheritance.bankaccounttypes;

	class SavingsAccount extends BankAccount {

	    double interestRate;

	    SavingsAccount(int accountNumber, double balance, double interestRate) {
	        super(accountNumber, balance);
	        this.interestRate = interestRate;
	    }

	    void displayAccountType() {
	        System.out.println("Account Type   : Savings Account");
	        System.out.println("Interest Rate : " + interestRate + "%");
	    }
	

}