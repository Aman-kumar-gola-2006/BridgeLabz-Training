import java.util.Scanner;

public class UniversityBST {

    // Node structure
    static class Node {
        int roll;
        Node left, right;

        Node(int roll) {
            this.roll = roll;
            left = right = null;
        }
    }

    static Node root = null;

    // Insert roll number
    static Node insert(Node root, int roll) {
        if (root == null) {
            return new Node(roll);
        }

        if (roll < root.roll) {
            root.left = insert(root.left, roll);
        } else if (roll > root.roll) {
            root.right = insert(root.right, roll);
        }

        return root;
    }

    // Search roll number
    static boolean search(Node root, int roll) {
        if (root == null) {
            return false;
        }

        if (root.roll == roll) {
            return true;
        } else if (roll < root.roll) {
            return search(root.left, roll);
        } else {
            return search(root.right, roll);
        }
    }

    // Find minimum value
    static int minValue(Node root) {
        int min = root.roll;
        while (root.left != null) {
            min = root.left.roll;
            root = root.left;
        }
        return min;
    }

    // Delete roll number
    static Node delete(Node root, int roll) {
        if (root == null) {
            return root;
        }

        if (roll < root.roll) {
            root.left = delete(root.left, roll);
        } else if (roll > root.roll) {
            root.right = delete(root.right, roll);
        } else {
            // case: one or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // case: two children
            root.roll = minValue(root.right);
            root.right = delete(root.right, root.roll);
        }

        return root;
    }

    // Inorder traversal (sorted order)
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.roll + " ");
            inorder(root.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- University Digital Record System ---");
            System.out.println("1. Insert Student Roll Number");
            System.out.println("2. Delete Student Roll Number");
            System.out.println("3. Search Student Roll Number");
            System.out.println("4. Display Sorted Roll Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number to insert: ");
                    int insertRoll = sc.nextInt();
                    root = insert(root, insertRoll);
                    System.out.println("Roll number inserted successfully.");
                    break;

                case 2:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRoll = sc.nextInt();
                    root = delete(root, deleteRoll);
                    System.out.println("Roll number deleted (if existed).");
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    if (search(root, searchRoll)) {
                        System.out.println("Student record found.");
                    } else {
                        System.out.println("Student record not found.");
                    }
                    break;

                case 4:
                    System.out.print("Sorted Roll Numbers: ");
                    inorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
