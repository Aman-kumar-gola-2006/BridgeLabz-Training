package com.encapsulationandpolymorphism.bankingsystem;

/*
 * Loanable interface
 * ------------------
 * Any account type that supports loans
 * must implement this interface.
 */
public interface Loanable {

    // Applies for a loan
    void applyForLoan(double amount);

    // Calculates loan eligibility based on balance
    double calculateLoanEligibility();
}

