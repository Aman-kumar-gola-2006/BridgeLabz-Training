import java.util.Scanner;

// Node class for each compartment
class Compartment {
    String name;                 // Compartment name (Pantry, WiFi, Sleeper, etc.)
    Compartment prev;            // Link to previous compartment
    Compartment next;            // Link to next compartment

    public Compartment(String name) {
        this.name = name;
    }
}

// Main TrainCompanion class
public class TrainCompanion {

    Compartment head;  // First compartment
    Compartment tail;  // Last compartment

    Scanner sc = new Scanner(System.in);

    // Insert new compartment at end
    void addCompartment() {
        System.out.print("Enter compartment name: ");
        String name = sc.next();

        Compartment newNode = new Compartment(name);

        // If first node
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Compartment added.");
    }

    // Remove a compartment by name
    void removeCompartment() {
        System.out.print("Enter compartment name to remove: ");
        String name = sc.next();

        Compartment temp = head;

        while (temp != null) {
            if (temp.name.equals(name)) {

                // Case 1: Removing head
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                }
                // Case 2: Removing tail
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // Case 3: Middle node
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Compartment removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Compartment not found.");
    }

    // Traverse forward direction
    void forwardTraverse() {
        System.out.println("Forward compartments:");
        Compartment temp = head;

        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Traverse backward direction
    void backwardTraverse() {
        System.out.println("Backward compartments:");
        Compartment temp = tail;

        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Search a compartment and show previous & next
    void searchCompartment() {
        System.out.print("Enter compartment name to search: ");
        String name = sc.next();

        Compartment temp = head;

        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println("Compartment Found: " + temp.name);

                // Show previous
                if (temp.prev != null)
                    System.out.println("Previous: " + temp.prev.name);
                else
                    System.out.println("Previous: None");

                // Show next
                if (temp.next != null)
                    System.out.println("Next: " + temp.next.name);
                else
                    System.out.println("Next: None");

                return;
            }
            temp = temp.next;
        }

        System.out.println("Compartment not found.");
    }

    public static void main(String[] args) {

        TrainCompanion train = new TrainCompanion();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nTrainCompanion Menu:");
            System.out.println("1. Add Compartment");
            System.out.println("2. Remove Compartment");
            System.out.println("3. Forward Traverse");
            System.out.println("4. Backward Traverse");
            System.out.println("5. Search Compartment");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: train.addCompartment(); break;
                case 2: train.removeCompartment(); break;
                case 3: train.forwardTraverse(); break;
                case 4: train.backwardTraverse(); break;
                case 5: train.searchCompartment(); break;
                case 6: 
                    System.out.println("Exit...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
