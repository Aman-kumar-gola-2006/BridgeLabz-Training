package com.exceptions.banksystem;

public class BankSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        try {
        	
            account.withdraw(5000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}