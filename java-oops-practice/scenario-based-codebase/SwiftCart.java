import java.util.ArrayList;

// ---------- Interface ----------
interface ICheckout {
    void generateBill();
    void applyDiscount();
}

// ---------- Base Product Class ----------
abstract class Product {
    protected String name;
    protected double price;
    protected String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Polymorphic method
    abstract double getDiscount(double total);
}

// ---------- Perishable Product ----------
class PerishableProduct extends Product {

    PerishableProduct(String name, double price) {
        super(name, price, "Perishable");
    }

    @Override
    double getDiscount(double total) {
        // 10% discount on perishable items
        return total * 0.10;
    }
}

// ---------- Non-Perishable Product ----------
class NonPerishableProduct extends Product {

    NonPerishableProduct(String name, double price) {
        super(name, price, "Non-Perishable");
    }

    @Override
    double getDiscount(double total) {
        // 5% discount
        return total * 0.05;
    }
}

// ---------- Cart Class ----------
class Cart implements ICheckout {
    private ArrayList<Product> products;
    private double totalPrice;   // Encapsulated

    // Constructor without items
    Cart() {
        products = new ArrayList<>();
        totalPrice = 0;
    }

    // Constructor with pre-selected items
    Cart(ArrayList<Product> items) {
        products = items;
        calculateTotal();
    }

    // Only Cart can update price
    private void calculateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.price;
        }
    }

    public void addProduct(Product p) {
        products.add(p);
        calculateTotal();
    }

    @Override
    public void applyDiscount() {
        double discount = 0;

        for (Product p : products) {
            discount += p.getDiscount(p.price); // polymorphism
        }

        totalPrice = totalPrice - discount; // operator usage
        System.out.println("Discount Applied: ₹" + discount);
    }

    @Override
    public void generateBill() {
        System.out.println("\n===== SwiftCart Bill =====");
        for (Product p : products) {
            System.out.println(p.name + " (" + p.category + ") : ₹" + p.price);
        }
        System.out.println("--------------------------");
        System.out.println("Final Payable Amount: ₹" + totalPrice);
    }
}

// ---------- Main Class ----------
public class SwiftCart {
    public static void main(String[] args) {

        // Products
        Product milk = new PerishableProduct("Milk", 50);
        Product vegetables = new PerishableProduct("Vegetables", 80);
        Product rice = new NonPerishableProduct("Rice", 120);
        Product oil = new NonPerishableProduct("Cooking Oil", 150);

        // Cart
        Cart cart = new Cart();
        cart.addProduct(milk);
        cart.addProduct(vegetables);
        cart.addProduct(rice);
        cart.addProduct(oil);

        // Checkout
        cart.applyDiscount();
        cart.generateBill();
    }
}
