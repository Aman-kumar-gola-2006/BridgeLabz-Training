package com.encapsulationandpolymorphism.bankingsystem;

/*
 * CurrentAccount class
 * --------------------
 * Designed for business users.
 * Earns lower interest but allows higher loan eligibility.
 */
public class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Current accounts earn 2% interest
    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }

    // Loan eligibility is 5 times the balance
    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
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
