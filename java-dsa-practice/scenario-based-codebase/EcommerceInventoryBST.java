import java.util.Scanner;

public class EcommerceInventoryBST {

    // Product Node
    static class Node {
        int sku;
        String name;
        double price;
        Node left, right;

        Node(int sku, String name, double price) {
            this.sku = sku;
            this.name = name;
            this.price = price;
            left = right = null;
        }
    }

    static Node root = null;

    // Insert product
    static Node insert(Node root, int sku, String name, double price) {
        if (root == null) {
            return new Node(sku, name, price);
        }

        if (sku < root.sku) {
            root.left = insert(root.left, sku, name, price);
        } else if (sku > root.sku) {
            root.right = insert(root.right, sku, name, price);
        }

        return root;
    }

    // Search product by SKU
    static Node search(Node root, int sku) {
        if (root == null || root.sku == sku) {
            return root;
        }

        if (sku < root.sku) {
            return search(root.left, sku);
        } else {
            return search(root.right, sku);
        }
    }

    // Update product price
    static void updatePrice(Node root, int sku, double newPrice) {
        Node product = search(root, sku);
        if (product != null) {
            product.price = newPrice;
            System.out.println("Price updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display products in sorted SKU order
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("SKU: " + root.sku +
                    ", Name: " + root.name +
                    ", Price: ₹" + root.price);
            inorder(root.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- E-Commerce Product Inventory ---");
            System.out.println("1. Add Product");
            System.out.println("2. Lookup Product by SKU");
            System.out.println("3. Update Product Price");
            System.out.println("4. Display Products (Sorted by SKU)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter SKU: ");
                    int sku = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    root = insert(root, sku, name, price);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter SKU to search: ");
                    int searchSku = sc.nextInt();
                    Node product = search(root, searchSku);

                    if (product != null) {
                        System.out.println("Product Found:");
                        System.out.println("Name: " + product.name);
                        System.out.println("Price: ₹" + product.price);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter SKU to update price: ");
                    int updateSku = sc.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    updatePrice(root, updateSku, newPrice);
                    break;

                case 4:
                    System.out.println("Product List (Sorted by SKU):");
                    inorder(root);
                    break;

                case 5:
                    System.out.println("Exiting inventory system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
