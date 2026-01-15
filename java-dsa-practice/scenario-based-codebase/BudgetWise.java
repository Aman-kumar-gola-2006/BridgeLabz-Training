import java.util.*;

// Transaction class
class Transaction {
    double amount;
    String type;      // income or expense
    String date;
    String category;

    public Transaction(double amount, String type, String date, String category) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.category = category;
    }
}

// Interface
interface IAnalyzable {
    void generateReport();
    void detectOverspend();
}

// Base Budget class with Encapsulation
abstract class Budget implements IAnalyzable {
    protected double income;
    protected double limit;

    protected HashMap<String, Double> categoryLimits;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Budget(double income, double limit, HashMap<String, Double> categoryLimits) {
        this.income = income;
        this.limit = limit;
        this.categoryLimits = categoryLimits;
    }

    // Encapsulation: expenses can be added, but cannot modify directly
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    protected ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Operator: net savings = income - total expenses
    protected double totalExpenses() {
        double sum = 0;
        for (Transaction t : transactions) {
            if (t.type.equalsIgnoreCase("expense")) {
                sum += t.amount;
            }
        }
        return sum;
    }

    protected double netSavings() {
        return income - totalExpenses();
    }
}

// MonthlyBudget class (Inheritance + Polymorphism)
class MonthlyBudget extends Budget {

    public MonthlyBudget(double income, double limit, HashMap<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    public void generateReport() {
        System.out.println("----- Monthly Budget Report ------");
        System.out.println("Total Income: " + income);
        System.out.println("Total Expenses: " + totalExpenses());
        System.out.println("Net Savings: " + netSavings());
    }

    public void detectOverspend() {
        for (String cat : categoryLimits.keySet()) {
            double spent = 0;
            for (Transaction t : getTransactions()) {
                if (t.category.equals(cat) && t.type.equals("expense")) {
                    spent += t.amount;
                }
            }

            if (spent > categoryLimits.get(cat)) {
                System.out.println("Overspend detected in category: " + cat);
            }
        }
    }
}

// AnnualBudget class (Inheritance + Polymorphism)
class AnnualBudget extends Budget {

    public AnnualBudget(double income, double limit, HashMap<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    public void generateReport() {
        System.out.println("====== Annual Budget Summary ======");
        System.out.println("Yearly Income: " + income);
        System.out.println("Yearly Expenses: " + totalExpenses());
        System.out.println("Annual Savings: " + netSavings());
    }

    public void detectOverspend() {
        System.out.println("Annual overspend checking...");
        if (totalExpenses() > limit) {
            System.out.println("You have exceeded yearly spending limit!");
        } else {
            System.out.println("Your spending is within the annual limit.");
        }
    }
}

// Main class (User Input)
public class BudgetWise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> categoryLimits = new HashMap<>();
        System.out.print("Enter number of categories: ");
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            System.out.print("Category name: ");
            String cat = sc.next();

            System.out.print("Limit for " + cat + ": ");
            double lim = sc.nextDouble();

            categoryLimits.put(cat, lim);
        }

        System.out.print("Enter income: ");
        double income = sc.nextDouble();

        System.out.print("Enter overall limit: ");
        double limit = sc.nextDouble();

        System.out.print("Choose type (1-Monthly, 2-Annual): ");
        int typeChoice = sc.nextInt();

        Budget budget;

        if (typeChoice == 1) {
            budget = new MonthlyBudget(income, limit, categoryLimits);
        } else {
            budget = new AnnualBudget(income, limit, categoryLimits);
        }

        while (true) {
            System.out.println("\n1. Add Transaction");
            System.out.println("2. Generate Report");
            System.out.println("3. Detect Overspend");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();

            if (option == 4) break;

            switch (option) {
                case 1:
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    System.out.print("Type (income/expense): ");
                    String type = sc.next();

                    System.out.print("Date: ");
                    String date = sc.next();

                    System.out.print("Category: ");
                    String cat = sc.next();

                    budget.addTransaction(new Transaction(amt, type, date, cat));
                    break;

                case 2:
                    budget.generateReport();
                    break;

                case 3:
                    budget.detectOverspend();
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
