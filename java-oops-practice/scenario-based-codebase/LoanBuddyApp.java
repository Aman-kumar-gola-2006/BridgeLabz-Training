// LoanBuddy – Loan Approval Automation
// Simple fresher-friendly implementation in one file for easy understanding.

import java.util.*;

// Interface defining essential operations
interface IApprovable {
    boolean approveLoan();
    double calculateEMI();
}

// Applicant class to store user details (Encapsulation)
class Applicant {
    private String name;
    private int creditScore;      // must stay private
    private double income;
    private double loanAmount;

    public Applicant(String name, int creditScore, double income, double loanAmount) {
        this.name = name;
        this.creditScore = creditScore;
        this.income = income;
        this.loanAmount = loanAmount;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    // Keep credit score private – used internally by approval logic
    protected int getCreditScore() {
        return creditScore;
    }
}

// Base LoanApplication class
class LoanApplication implements IApprovable {

    protected Applicant applicant;
    protected String loanType;
    protected int termMonths;           // loan duration
    protected double interestRate;      // annual interest rate

    // Constructor for basic loan
    public LoanApplication(Applicant applicant, String loanType, int termMonths, double interestRate) {
        this.applicant = applicant;
        this.loanType = loanType;
        this.termMonths = termMonths;
        this.interestRate = interestRate;
    }

    // Loan approval logic (Encapsulation – kept private)
    private boolean internalApprovalCheck() {
        // Very simple rule: must have good credit and enough income
        return applicant.getCreditScore() >= 650 && applicant.getIncome() >= 20000;
    }

    @Override
    public boolean approveLoan() {
        boolean result = internalApprovalCheck();
        if (result) {
            System.out.println("Loan Approved for: " + applicant.getName());
        } else {
            System.out.println("Loan Rejected for: " + applicant.getName());
        }
        return result;
    }

    // EMI Formula:
    // EMI = P × R × (1+R)^N / ((1+R)^N – 1)
    @Override
    public double calculateEMI() {
        double P = applicant.getLoanAmount();
        double annualRate = interestRate / 100;
        double R = annualRate / 12;        // monthly interest
        int N = termMonths;

        double numerator = P * R * Math.pow(1 + R, N);
        double denominator = Math.pow(1 + R, N) - 1;

        return numerator / denominator;
    }

    public void showRepaymentPlan() {
        double emi = calculateEMI();
        System.out.println("Monthly EMI: " + emi);
        System.out.println("Total Payable: " + (emi * termMonths));
    }
}

// Home Loan class (Inheritance)
class HomeLoan extends LoanApplication {

    public HomeLoan(Applicant applicant, int termMonths) {
        // Home loans usually have lower interest
        super(applicant, "Home Loan", termMonths, 7.5);
    }

    // Polymorphism: Home loan may give reduced EMI
    @Override
    public double calculateEMI() {
        System.out.println("Calculating EMI using Home Loan rules...");
        return super.calculateEMI() * 0.95;   // 5% discount for long-term stability
    }
}

// Auto Loan class (Inheritance)
class AutoLoan extends LoanApplication {

    public AutoLoan(Applicant applicant, int termMonths) {
        // Auto loans have a different interest rate
        super(applicant, "Auto Loan", termMonths, 9.2);
    }

    // Polymorphism: Additional processing for auto loans
    @Override
    public double calculateEMI() {
        System.out.println("Calculating EMI using Auto Loan rules...");
        return super.calculateEMI();
    }
}

// Main app to test the system
public class LoanBuddyApp {

    public static void main(String[] args) {

        Applicant a1 = new Applicant("Aman", 720, 45000, 500000);
        Applicant a2 = new Applicant("Rohit", 580, 30000, 300000);

        // Home Loan application
        HomeLoan homeLoan = new HomeLoan(a1, 240);   // 20 years
        homeLoan.approveLoan();
        System.out.println("Home Loan EMI: " + homeLoan.calculateEMI());
        homeLoan.showRepaymentPlan();

        System.out.println("\n------------------------------\n");

        // Auto Loan application
        AutoLoan autoLoan = new AutoLoan(a2, 60);    // 5 years
        autoLoan.approveLoan();
        System.out.println("Auto Loan EMI: " + autoLoan.calculateEMI());
        autoLoan.showRepaymentPlan();

    }
}
