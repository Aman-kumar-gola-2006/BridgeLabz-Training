// MediStore – Pharmacy Inventory & Sales System
// All classes in one file, beginner-friendly, using Scanner for user input

import java.util.*;

// Interface for selling and expiry check
interface ISellable {
    boolean sell(int qty);
    boolean checkExpiry();
}

// Base Medicine Class
class Medicine implements ISellable {

    protected String name;
    protected double price;
    protected String expiryDate;
    private int quantity;               // Encapsulation: stock hidden

    // Constructor with default quantity
    public Medicine(String name, double price, String expiryDate) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = 50;             // default stock
    }

    // Constructor with custom quantity
    public Medicine(String name, double price, String expiryDate, int quantity) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    // Get stock
    public int getStock() {
        return quantity;
    }

    // Private pricing logic (Sensitive)
    private double calculateTotalPrice(int qty) {
        double discount = 0;

        // Simple discount rule
        if (qty >= 10) {
            discount = price * qty * 0.10;  // 10% discount
        }

        return (price * qty) - discount;    // Operator usage
    }

    // Selling logic
    @Override
    public boolean sell(int qty) {
        if (qty <= quantity) {
            quantity -= qty;  // Adjust stock
            double totalPrice = calculateTotalPrice(qty);
            System.out.println("Total Price: " + totalPrice);
            return true;
        } else {
            System.out.println("Not enough stock.");
            return false;
        }
    }

    // Polymorphic expiry check (Base behavior)
    @Override
    public boolean checkExpiry() {
        System.out.println("Checking expiry for general medicine...");
        return !expiryDate.equals("2024-01-01"); // dummy check
    }
}

// Subclass — Tablet (solid medicines)
class Tablet extends Medicine {
    public Tablet(String name, double price, String expiryDate, int qty) {
        super(name, price, expiryDate, qty);
    }

    // Polymorphism: Tablets last longer
    @Override
    public boolean checkExpiry() {
        System.out.println("Checking expiry for Tablet...");
        return true;   // Tablets generally preserved
    }
}

// Subclass — Syrup (liquid medicines)
class Syrup extends Medicine {
    public Syrup(String name, double price, String expiryDate, int qty) {
        super(name, price, expiryDate, qty);
    }

    // Polymorphism: Liquids expire faster
    @Override
    public boolean checkExpiry() {
        System.out.println("Checking expiry for Syrup...");
        if (expiryDate.compareTo("2025-01-01") < 0) {
            return false;
        }
        return true;
    }
}

// Subclass — Injection
class Injection extends Medicine {
    public Injection(String name, double price, String expiryDate, int qty) {
        super(name, price, expiryDate, qty);
    }

    @Override
    public boolean checkExpiry() {
        System.out.println("Checking expiry for Injection...");
        return !expiryDate.equals("2023-12-01");
    }
}

// Main App Class
public class MediStoreApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== MediStore – Pharmacy Inventory System ===");

        // Taking medicine details from user
        System.out.print("Enter Medicine Type (tablet/syrup/injection): ");
        String type = sc.nextLine();

        System.out.print("Enter Medicine Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        sc.nextLine();  // buffer clear
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        String expiry = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        Medicine med = null;

        // Creating object based on user type
        if (type.equalsIgnoreCase("tablet")) {
            med = new Tablet(name, price, expiry, qty);
        } else if (type.equalsIgnoreCase("syrup")) {
            med = new Syrup(name, price, expiry, qty);
        } else if (type.equalsIgnoreCase("injection")) {
            med = new Injection(name, price, expiry, qty);
        } else {
            System.out.println("Invalid medicine type!");
            return;
        }

        // Check expiry
        boolean valid = med.checkExpiry();
        System.out.println("Medicine Valid? " + valid);

        // Sell medicine
        System.out.print("\nEnter quantity to sell: ");
        int sellQty = sc.nextInt();

        med.sell(sellQty);

        // Display final stock
        System.out.println("Remaining Stock: " + med.getStock());

        sc.close();
    }
}
