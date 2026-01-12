import java.util.*;

public class CallCenterManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Normal customer queue
        Queue<String> normalQueue = new LinkedList<>();

        // Priority customer queue (VIP)
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        // HashMap to store how many times a user has called this month
        HashMap<String, Integer> callCount = new HashMap<>();

        System.out.println("How many customers want to call?");
        int n = sc.nextInt();
        sc.nextLine();  // consume next line

        for (int i = 0; i < n; i++) {

            System.out.println("Enter customer name:");
            String name = sc.nextLine();

            System.out.println("Is this customer VIP? (yes/no):");
            String vip = sc.nextLine();

            // Update call count in HashMap
            callCount.put(name, callCount.getOrDefault(name, 0) + 1);

            // Add to correct queue
            if (vip.equalsIgnoreCase("yes")) {
                priorityQueue.add(name);     // VIP goes to priority queue
            } else {
                normalQueue.add(name);       // Normal user goes to normal queue
            }
        }

        System.out.println("\n--- SERVING CUSTOMERS ---");

        // Serve VIP customers first
        while (!priorityQueue.isEmpty()) {
            String customer = priorityQueue.poll();
            System.out.println("Serving VIP customer: " + customer + 
                               " | Total Calls: " + callCount.get(customer));
        }

        // Then serve normal customers
        while (!normalQueue.isEmpty()) {
            String customer = normalQueue.poll();
            System.out.println("Serving Normal customer: " + customer + 
                               " | Total Calls: " + callCount.get(customer));
        }

        System.out.println("\n--- Monthly Call Record ---");
        for (String key : callCount.keySet()) {
            System.out.println(key + " called " + callCount.get(key) + " times.");
        }

        sc.close();
    }
}
