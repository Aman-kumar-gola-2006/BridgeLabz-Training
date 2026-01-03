class Customer {
    String name;
    int customerId;

    Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    void displayCustomer() {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer ID: " + customerId);
    }
}

class Account {
    String accountNumber;
    double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    boolean checkLoanEligibility() {
        if (balance >= 50000) {
            return true;
        }
        return false;
    }

    void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {

    double interestRate;

    SavingsAccount(String accNo, double bal, double rate) {
        super(accNo, bal);
        this.interestRate = rate;
    }

    double calculateInterest() {
        return (balance * interestRate) / 100;
    }

    double calculateDiscount() {
        if (balance > 100000)
            return 500;
        else
            return 200;
    }
}

public class BankSystem {

    public static void main(String[] args) {

        Customer c1 = new Customer("Aman", 101);
        SavingsAccount acc = new SavingsAccount("SB101", 75000, 5);

        System.out.println("----- CUSTOMER DETAILS -----");
        c1.displayCustomer();

        System.out.println("\n----- ACCOUNT DETAILS -----");
        acc.displayAccount();

        System.out.println("\n----- LOAN STATUS -----");
        if (acc.checkLoanEligibility()) {
            System.out.println("Loan Approved");
        } else {
            System.out.println("Loan Not Approved");
        }

        System.out.println("\nInterest: " + acc.calculateInterest());
        System.out.println("Discount: " + acc.calculateDiscount());
    }
}
