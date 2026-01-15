import java.util.*;

// Node class for Singly Linked List (Each parcel stage)
class Stage {
    String name;
    Stage next;

    public Stage(String name) {
        this.name = name;
        this.next = null;
    }
}

// Main Tracking System
public class ParcelTracker {

    Stage head = null;

    // Add a stage at the end
    public void addStage(String name) {
        Stage newStage = new Stage(name);

        if (head == null) {
            head = newStage;
            return;
        }

        Stage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newStage;
    }

    // Insert custom checkpoint after a given stage
    public void addCheckpoint(String afterStage, String checkpointName) {
        Stage temp = head;

        while (temp != null) {
            if (temp.name.equals(afterStage)) {
                Stage newNode = new Stage(checkpointName);
                newNode.next = temp.next;
                temp.next = newNode;
                System.out.println("Checkpoint added after " + afterStage);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Stage not found.");
    }

    // Track parcel forward
    public void trackParcel() {
        if (head == null) {
            System.out.println("No tracking stages available.");
            return;
        }

        Stage temp = head;

        System.out.println("Tracking Parcel:");

        while (temp != null) {
            System.out.println("Stage: " + temp.name);

            // Missing / Lost Parcel Handling
            if (temp.next == null && !temp.name.equals("Delivered")) {
                System.out.println("WARNING: Parcel missing before reaching final stage.");
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParcelTracker tracker = new ParcelTracker();

        // Default delivery chain
        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        while (true) {
            System.out.println("\n--- ParcelTracker Menu ---");
            System.out.println("1. View Tracking");
            System.out.println("2. Add Checkpoint");
            System.out.println("3. Simulate Lost Parcel");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int ch = sc.nextInt();

            if (ch == 4) break;

            switch (ch) {
                case 1:
                    tracker.trackParcel();
                    break;

                case 2:
                    System.out.print("Enter stage name after which to add checkpoint: ");
                    String after = sc.next();
                    System.out.print("Enter checkpoint name: ");
                    String check = sc.next();
                    tracker.addCheckpoint(after, check);
                    break;

                case 3:
                    System.out.println("Simulating lost parcel… removing next pointer of 'In Transit'");
                    Stage temp = tracker.head;
                    while (temp != null) {
                        if (temp.name.equals("In Transit")) {
                            temp.next = null;  // NULL → parcel vanishes
                            break;
                        }
                        temp = temp.next;
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
