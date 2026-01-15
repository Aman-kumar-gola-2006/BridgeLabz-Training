import java.util.*;

// Customer class
class Customer {
    String name;
    ArrayList<String> items;

    public Customer(String name, ArrayList<String> items) {
        this.name = name;
        this.items = items;
    }
}

// SmartCheckout system
public class SmartCheckout {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // HashMap for price and stock
        HashMap<String, Double> priceMap = new HashMap<>();
        HashMap<String, Integer> stockMap = new HashMap<>();

        // Add sample items to supermarket
        priceMap.put("Milk", 50.0);
        priceMap.put("Bread", 30.0);
        priceMap.put("Eggs", 6.0);

        stockMap.put("Milk", 10);
        stockMap.put("Bread", 20);
        stockMap.put("Eggs", 100);

        Queue<Customer> queue = new LinkedList<>();

        while (true) {
            System.out.println("\n--- SmartCheckout Menu ---");
            System.out.println("1. Add Customer to Queue");
            System.out.println("2. Process Next Customer");
            System.out.println("3. View Queue");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            if (ch == 4) break;

            switch (ch) {

                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.next();

                    System.out.print("How many items? ");
                    int n = sc.nextInt();

                    ArrayList<String> items = new ArrayList<>();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter item name: ");
                        items.add(sc.next());
                    }

                    queue.add(new Customer(name, items));
                    System.out.println("Customer added to queue.");
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No customers to process.");
                        break;
                    }

                    Customer current = queue.poll(); // Remove from queue
                    double totalBill = 0;

                    System.out.println("Processing customer: " + current.name);

                    for (String item : current.items) {

                        if (!priceMap.containsKey(item)) {
                            System.out.println("Item not found: " + item);
                            continue;
                        }

                        if (stockMap.get(item) <= 0) {
                            System.out.println(item + " is out of stock.");
                            continue;
                        }

                        // Fetch item price
                        double price = priceMap.get(item);
                        totalBill += price;

                        // Update stock
                        stockMap.put(item, stockMap.get(item) - 1);
                    }

                    System.out.println("Total bill for " + current.name + ": Rs. " + totalBill);
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Customers in queue:");
                        for (Customer c : queue) {
                            System.out.println("- " + c.name);
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
