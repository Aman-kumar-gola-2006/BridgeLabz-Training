import java.util.Scanner;

// Node for Circular Linked List
class UnitNode {
    String unitName;
    boolean available;        // true = unit is available
    UnitNode next;

    UnitNode(String name, boolean available) {
        this.unitName = name;
        this.available = available;
    }
}

class AmbulanceRoute {

    UnitNode head;     // starting point of the circular route

    // Add new unit into circular linked list
    void addUnit(String name, boolean available) {
        UnitNode newUnit = new UnitNode(name, available);

        // If no unit present, create first unit
        if (head == null) {
            head = newUnit;
            newUnit.next = head;     // circular connection
            return;
        }

        // Otherwise insert at end and connect circular link
        UnitNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newUnit;
        newUnit.next = head;
    }

    // Remove a unit (maintenance)
    void removeUnit(String name) {
        if (head == null) {
            System.out.println("No units in route.");
            return;
        }

        UnitNode temp = head;
        UnitNode prev = null;

        // If head needs removal
        if (temp.unitName.equalsIgnoreCase(name)) {

            // Only one unit present
            if (temp.next == head) {
                head = null;
                System.out.println("Unit removed.");
                return;
            }

            // Move to last node to fix circular connection
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = head.next;   // connect last to 2nd node
            head = head.next;         // update head
            System.out.println("Unit removed.");
            return;
        }

        // Removing any middle unit
        temp = head;
        while (temp.next != head) {
            prev = temp;
            temp = temp.next;

            if (temp.unitName.equalsIgnoreCase(name)) {
                prev.next = temp.next;
                System.out.println("Unit removed.");
                return;
            }
        }

        System.out.println("Unit not found.");
    }

    // Find the nearest available unit by rotating circularly
    void findNearestUnit() {
        if (head == null) {
            System.out.println("No units available.");
            return;
        }

        UnitNode temp = head;

        // rotate circularly until available unit is found
        do {
            if (temp.available) {
                System.out.println("Nearest Available Unit: " + temp.unitName);
                return;
            }
            temp = temp.next;

        } while (temp != head);

        System.out.println("No unit is available right now.");
    }

    // Display all units
    void displayUnits() {
        if (head == null) {
            System.out.println("No units to show.");
            return;
        }

        UnitNode temp = head;
        System.out.println("Units in circular route:");

        do {
            System.out.println("- " + temp.unitName + " (Available: " + temp.available + ")");
            temp = temp.next;
        } while (temp != head);
    }
}


// Driver Program
public class AmbulanceRouteMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AmbulanceRoute route = new AmbulanceRoute();

        while (true) {

            System.out.println("\n===== Ambulance Route Menu =====");
            System.out.println("1. Add Hospital Unit");
            System.out.println("2. Remove Unit (Maintenance)");
            System.out.println("3. Check Nearest Available Unit");
            System.out.println("4. Display All Units");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Unit Name: ");
                    String name = sc.nextLine();

                    System.out.print("Is this unit Available? (true/false): ");
                    boolean available = sc.nextBoolean();

                    route.addUnit(name, available);
                    System.out.println("Unit Added.");
                    break;

                case 2:
                    System.out.print("Enter Unit Name to Remove: ");
                    String removeName = sc.nextLine();
                    route.removeUnit(removeName);
                    break;

                case 3:
                    route.findNearestUnit();
                    break;

                case 4:
                    route.displayUnits();
                    break;

                case 5:
                    System.out.println("Exiting System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
