// BookBazaar – Digital Bookstore System
// Fresher-friendly clean logic with comments for understanding
// All classes are kept in one file

import java.util.*;

// Interface for discounted items
interface IDiscountable {
    double applyDiscount(double price);
}

// Base Book Class
class Book implements IDiscountable {

    protected String title;
    protected String author;
    protected double price;
    private int stock;                 // Encapsulation: stock cannot be changed directly
    protected double offer;            // optional offer on book

    // Constructor without offer
    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.offer = 0;                // default no discount
    }

    // Constructor with offer (optional)
    public Book(String title, String author, double price, int stock, double offer) {
        this(title, author, price, stock);
        this.offer = offer;
    }

    // Getter for stock
    public int getStock() {
        return stock;
    }

    // Reduce stock only via method (Encapsulation)
    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("Not enough stock for: " + title);
        }
    }

    // Base discount logic (polymorphic, overridden in child classes)
    @Override
    public double applyDiscount(double price) {
        return price - offer;
    }

    public void showBook() {
        System.out.println(title + " by " + author + " | Price: " + price + " | Stock: " + stock);
    }
}

// Child Class: EBook
class EBook extends Book {

    public EBook(String title, String author, double price, int stock, double offer) {
        super(title, author, price, stock, offer);
    }

    // Polymorphism: EBooks give more discount
    @Override
    public double applyDiscount(double price) {
        System.out.println("Applying EBook discount...");
        return price - (offer + 20);          // extra flat discount
    }
}

// Child Class: PrintedBook
class PrintedBook extends Book {

    public PrintedBook(String title, String author, double price, int stock, double offer) {
        super(title, author, price, stock, offer);
    }

    // Polymorphism: Printed Books have packaging charges
    @Override
    public double applyDiscount(double price) {
        System.out.println("Applying PrintedBook discount...");
        return price - offer + 10;            // +10 packaging cost
    }
}

// Order Class linking User to Books
class Order {

    private String userName;
    private List<Book> items = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();

    private String status = "PENDING";        // Access-controlled status

    public Order(String userName) {
        this.userName = userName;
    }

    // Add book with quantity
    public void addBook(Book book, int quantity) {
        if (book.getStock() >= quantity) {
            items.add(book);
            quantities.add(quantity);
            book.reduceStock(quantity);
        } else {
            System.out.println("Not enough stock to add: " + book.title);
        }
    }

    // Calculate total using operators: price × quantity – discount
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            Book b = items.get(i);
            int q = quantities.get(i);
            double discountedPrice = b.applyDiscount(b.price);

            total += (discountedPrice * q);   // Operator-based computation
        }
        return total;
    }

    // Restrict status update using method only
    public void updateStatus(String newStatus) {
        if (newStatus.equals("CONFIRMED") || newStatus.equals("CANCELLED")) {
            status = newStatus;
        } else {
            System.out.println("Invalid status update.");
        }
    }

    public void showOrder() {
        System.out.println("\n----- ORDER SUMMARY -----");
        System.out.println("User: " + userName);
        System.out.println("Books Ordered:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("- " + items.get(i).title + " x " + quantities.get(i));
        }
        System.out.println("Status: " + status);
        System.out.println("Total Payable: " + calculateTotal());
    }
}

// Main class to test BookBazaar system
public class BookBazaarApp {

    public static void main(String[] args) {

        // Books created using constructors with offers
        EBook ebook1 = new EBook("Java Mastery", "James", 500, 20, 50);
        PrintedBook book1 = new PrintedBook("Clean Code", "Robert C. Martin", 700, 15, 30);

        // Show initial inventory
        ebook1.showBook();
        book1.showBook();

        // Create a new order for user
        Order order = new Order("Aman Kumar Gola");

        // Add books
        order.addBook(ebook1, 2);
        order.addBook(book1, 1);

        // Update order status safely
        order.updateStatus("CONFIRMED");

        // Show final order summary
        order.showOrder();
    }
}
