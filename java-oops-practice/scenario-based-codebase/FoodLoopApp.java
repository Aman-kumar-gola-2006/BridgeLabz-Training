import java.util.*;

// Interface for order operations
interface IOrderable {
    void placeOrder();
    void cancelOrder();
}

// Base FoodItem class
class FoodItem {
    protected String name;
    protected String category;
    protected double price;
    private int stock; // Encapsulated stock level

    FoodItem(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void reduceStock() {
        if (stock > 0) stock--;
    }

    public double getPrice() {
        return price;
    }
}

// Veg Item
class VegItem extends FoodItem {
    VegItem(String name, double price, int stock) {
        super(name, "Veg", price, stock);
    }
}

// Non Veg Item
class NonVegItem extends FoodItem {
    NonVegItem(String name, double price, int stock) {
        super(name, "Non-Veg", price, stock);
    }
}

// Order class
class Order implements IOrderable {
    private List<FoodItem> items;
    private double total;

    Order() {
        items = new ArrayList<>();
        total = 0;
    }

    // Constructor for custom Combo Meal
    Order(List<FoodItem> comboItems) {
        items = comboItems;
        calculateTotal();
    }

    public void addItem(FoodItem item) {
        items.add(item);
        item.reduceStock();
        calculateTotal();
    }

    // Polymorphism: discount changes based on total
    private double applyDiscount(double total) {
        if (total > 500) return total * 0.80;   // 20% off
        if (total > 300) return total * 0.90;   // 10% off
        return total;                            // no discount
    }

    private void calculateTotal() {
        double sum = 0;
        for (FoodItem item : items) {
            sum += item.getPrice();
        }
        total = applyDiscount(sum);
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        System.out.println("Items Count: " + items.size());
        System.out.println("Total After Discount: " + total);
    }

    public void cancelOrder() {
        System.out.println("Order cancelled successfully!");
    }
}

// Main Application
public class FoodLoopApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.println("Welcome to FoodLoop Ordering System!");

        // Menu creation
        FoodItem veg1 = new VegItem("Paneer Tikka", 200, 10);
        FoodItem veg2 = new VegItem("Veg Burger", 120, 10);
        FoodItem non1 = new NonVegItem("Chicken Biryani", 250, 10);
        FoodItem non2 = new NonVegItem("Egg Roll", 80, 10);

        Order order = new Order();

        while (true) {
            System.out.println("\nChoose Item to Order:");
            System.out.println("1. Paneer Tikka - 200");
            System.out.println("2. Veg Burger - 120");
            System.out.println("3. Chicken Biryani - 250");
            System.out.println("4. Egg Roll - 80");
            System.out.println("5. Place Order");
            System.out.println("6. Cancel Order");
            System.out.print("Enter option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (veg1.isAvailable()) order.addItem(veg1);
                    else System.out.println("Out of Stock!");
                    break;
                case 2:
                    if (veg2.isAvailable()) order.addItem(veg2);
                    else System.out.println("Out of Stock!");
                    break;
                case 3:
                    if (non1.isAvailable()) order.addItem(non1);
                    else System.out.println("Out of Stock!");
                    break;
                case 4:
                    if (non2.isAvailable()) order.addItem(non2);
                    else System.out.println("Out of Stock!");
                    break;
                case 5:
                    order.placeOrder();
                    return;
                case 6:
                    order.cancelOrder();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
