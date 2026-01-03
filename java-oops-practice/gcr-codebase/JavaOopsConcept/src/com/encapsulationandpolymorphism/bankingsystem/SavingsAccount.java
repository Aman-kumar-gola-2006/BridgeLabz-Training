package com.encapsulationandpolymorphism.bankingsystem;

/*
 * SavingsAccount class
 * --------------------
 * Designed for individuals who earn interest on savings.
 */
public class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Savings account earns 4% annual interest
    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }

    // Loan eligibility is 3 times the balance
    @Override
    public double calculateLoanEligibility() {
        return balance * 3;
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= calculateLoanEligibility()) {
            System.out.println("Loan Approved: ₹" + amount);
        } else {
            System.out.println("Loan Rejected: Exceeds eligibility.");
        }
    }
}

