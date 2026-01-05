import java.util.Scanner;

// ---------- Interface ----------
interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// ---------- Base Class ----------
abstract class Account implements ITransaction {
    protected int accountNumber;
    private double balance;   // Encapsulated

    // Constructor without opening balance
    Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    // Constructor with opening balance
    Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Protected access for child classes
    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Polymorphic method
    abstract double calculateInterest();
}

// ---------- Savings Account ----------
class SavingsAccount extends Account {
    private double interestRate = 4.0; // 4%

    SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    double calculateInterest() {
        // balance * interestRate / 100
        return getBalance() * interestRate / 100;
    }
}

// ---------- Current Account ----------
class CurrentAccount extends Account {
    private double interestRate = 2.0; // 2%

    CurrentAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

// ---------- Main Class ----------
public class MyBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to MyBank");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose Account Type: ");
        int choice = sc.nextInt();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Opening Balance: ");
        double balance = sc.nextDouble();

        Account account;

        if (choice == 1) {
            account = new SavingsAccount(accNo, balance);
        } else {
            account = new CurrentAccount(accNo, balance);
        }

        System.out.print("Enter Deposit Amount: ");
        account.deposit(sc.nextDouble());

        System.out.print("Enter Withdraw Amount: ");
        account.withdraw(sc.nextDouble());

        account.checkBalance();

        double interest = account.calculateInterest();
        System.out.println("Interest Earned: ₹" + interest);

        sc.close();
    }
}
