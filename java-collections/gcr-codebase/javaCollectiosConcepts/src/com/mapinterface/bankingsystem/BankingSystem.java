package com.mapinterface.bankingsystem;
import java.util.*;

public class BankingSystem {

    // HashMap: account number -> balance
    Map<String, Integer> accounts = new HashMap<>();

    // Queue: withdrawal requests
    Queue<String> withdrawalQueue = new LinkedList<>();

    // Add account
    public void addAccount(String accNo, int balance) {
        accounts.put(accNo, balance);
    }

    // Request withdrawal
    public void requestWithdrawal(String accNo) {
        withdrawalQueue.add(accNo);
    }

    // Process withdrawals
    public void processWithdrawals(int amount) {

        while (!withdrawalQueue.isEmpty()) {
            String accNo = withdrawalQueue.poll();

            int balance = accounts.get(accNo);

            if (balance >= amount) {
                accounts.put(accNo, balance - amount);
                System.out.println("Withdrawal successful for " + accNo);
            } else {
                System.out.println("Insufficient balance for " + accNo);
            }
        }
    }

    // Display accounts sorted by balance
    public void showAccountsSortedByBalance() {

        TreeMap<Integer, List<String>> sorted = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
            int balance = entry.getValue();
            sorted.putIfAbsent(balance, new ArrayList<>());
            sorted.get(balance).add(entry.getKey());
        }

        System.out.println("Accounts Sorted by Balance: " + sorted);
    }

    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 3000);
        bank.addAccount("A103", 7000);

        bank.requestWithdrawal("A101");
        bank.requestWithdrawal("A102");

        bank.processWithdrawals(2000);
        bank.showAccountsSortedByBalance();
    }
}
