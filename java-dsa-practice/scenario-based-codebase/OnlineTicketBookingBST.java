import java.util.Scanner;

public class OnlineTicketBookingBST {

    // Event Node
    static class Node {
        int eventId;
        int startTime;
        Node left, right;

        Node(int eventId, int startTime) {
            this.eventId = eventId;
            this.startTime = startTime;
            left = right = null;
        }
    }

    static Node root = null;

    // Insert event based on start time
    static Node insert(Node root, int eventId, int startTime) {
        if (root == null) {
            return new Node(eventId, startTime);
        }

        if (startTime < root.startTime) {
            root.left = insert(root.left, eventId, startTime);
        } else {
            root.right = insert(root.right, eventId, startTime);
        }

        return root;
    }

    // Find minimum node (for delete)
    static Node minValue(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Delete cancelled event
    static Node delete(Node root, int startTime) {
        if (root == null)
            return root;

        if (startTime < root.startTime) {
            root.left = delete(root.left, startTime);
        } else if (startTime > root.startTime) {
            root.right = delete(root.right, startTime);
        } else {
            // Case: one or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case: two children
            Node temp = minValue(root.right);
            root.startTime = temp.startTime;
            root.eventId = temp.eventId;
            root.right = delete(root.right, temp.startTime);
        }
        return root;
    }

    // Display events in upcoming order
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Event ID: " + root.eventId +
                               " | Start Time: " + root.startTime);
            inorder(root.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Online Ticket Booking System ---");
            System.out.println("1. Insert Event");
            System.out.println("2. Cancel Event");
            System.out.println("3. Show Upcoming Events");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Event ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Start Time (e.g. 930 for 9:30 AM): ");
                    int time = sc.nextInt();

                    root = insert(root, id, time);
                    System.out.println("Event added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Start Time of event to cancel: ");
                    int delTime = sc.nextInt();

                    root = delete(root, delTime);
                    System.out.println("Event cancelled (if existed).");
                    break;

                case 3:
                    System.out.println("Upcoming Events (Sorted by Time):");
                    inorder(root);
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
