import java.util.Scanner;

public class HospitalQueueBST {

    // Patient Node
    static class Node {
        int patientId;
        int checkInTime;
        Node left, right;

        Node(int patientId, int checkInTime) {
            this.patientId = patientId;
            this.checkInTime = checkInTime;
            left = right = null;
        }
    }

    static Node root = null;

    // Register patient (insert by check-in time)
    static Node insert(Node root, int patientId, int checkInTime) {
        if (root == null) {
            return new Node(patientId, checkInTime);
        }

        if (checkInTime < root.checkInTime) {
            root.left = insert(root.left, patientId, checkInTime);
        } else {
            root.right = insert(root.right, patientId, checkInTime);
        }

        return root;
    }

    // Find minimum node (used in delete)
    static Node minValue(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Discharge patient (delete record)
    static Node delete(Node root, int checkInTime) {
        if (root == null)
            return root;

        if (checkInTime < root.checkInTime) {
            root.left = delete(root.left, checkInTime);
        } else if (checkInTime > root.checkInTime) {
            root.right = delete(root.right, checkInTime);
        } else {
            // One or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Two children
            Node temp = minValue(root.right);
            root.checkInTime = temp.checkInTime;
            root.patientId = temp.patientId;
            root.right = delete(root.right, temp.checkInTime);
        }
        return root;
    }

    // Display patients by arrival time
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Patient ID: " + root.patientId +
                               " | Check-in Time: " + root.checkInTime);
            inorder(root.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hospital Queue Management ---");
            System.out.println("1. Patient Registration");
            System.out.println("2. Discharge Patient");
            System.out.println("3. Display Patients by Arrival Time");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Check-in Time (e.g. 1015 for 10:15 AM): ");
                    int time = sc.nextInt();

                    root = insert(root, id, time);
                    System.out.println("Patient registered successfully.");
                    break;

                case 2:
                    System.out.print("Enter Check-in Time of patient to discharge: ");
                    int delTime = sc.nextInt();

                    root = delete(root, delTime);
                    System.out.println("Patient discharged (if existed).");
                    break;

                case 3:
                    System.out.println("Patients by Arrival Time:");
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
