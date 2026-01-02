package com.inheritance.hierarchicalinheritance.bankaccounttypes;

class CheckingAccount extends BankAccount {

    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type      : Checking Account");
        System.out.println("Withdrawal Limit : ₹" + withdrawalLimit);
    }
}