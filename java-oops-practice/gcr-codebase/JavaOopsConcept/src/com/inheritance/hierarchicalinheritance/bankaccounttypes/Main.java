package com.inheritance.hierarchicalinheritance.bankaccounttypes;

public class Main {
	

	    public static void main(String[] args) {

	        SavingsAccount sa = new SavingsAccount(101, 50000, 4.5);
	        CheckingAccount ca = new CheckingAccount(102, 30000, 10000);
	        FixedDepositAccount fd = new FixedDepositAccount(103, 200000, 5);

	        sa.displayDetails();
	        sa.displayAccountType();
	        System.out.println("----------------");

	        ca.displayDetails();
	        ca.displayAccountType();
	        System.out.println("----------------");

	        fd.displayDetails();
	        fd.displayAccountType();
	    }

}