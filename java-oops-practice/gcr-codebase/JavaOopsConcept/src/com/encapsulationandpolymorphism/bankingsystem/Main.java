package com.encapsulationandpolymorphism.bankingsystem;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism by processing
 * different account types using BankAccount references.
 */
public class Main {

    // Polymorphic method to process interest and loan
    public static void processAccounts(List<BankAccount> accounts) {

        System.out.println("\n========== BANK ACCOUNT SUMMARY ==========\n");

        for (BankAccount account : accounts) {

            account.displayAccountDetails();

            double interest = account.calculateInterest();
            System.out.println("Interest Earned: ₹" + interest);

            // Loan processing if supported
            if (account instanceof Loanable loanableAccount) {
                System.out.println("Loan Eligibility: ₹" + loanableAccount.calculateLoanEligibility());
                loanableAccount.applyForLoan(50000);
            }

            System.out.println("------------------------------------------\n");
        }
    }

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        // -------- Savings Accounts (3 examples) --------
        accounts.add(new SavingsAccount("SB12345678", "Abhay", 80000));
        accounts.add(new SavingsAccount("SB87654321", "Aman", 60000));
        accounts.add(new SavingsAccount("SB11223344", "Riya", 100000));

        // -------- Current Accounts (3 examples) --------
        accounts.add(new CurrentAccount("CA99887766", "TechCorp", 200000));
        accounts.add(new CurrentAccount("CA44556677", "RetailMart", 150000));
        accounts.add(new CurrentAccount("CA22334455", "LogisticsLtd", 300000));

        // Process all accounts polymorphically
        processAccounts(accounts);
    }
}

