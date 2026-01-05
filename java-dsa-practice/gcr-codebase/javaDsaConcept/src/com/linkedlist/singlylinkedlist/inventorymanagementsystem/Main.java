package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static InventoryManagement inventory = new InventoryManagement();

    public static void main(String[] args) {

        int choice;

        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addItemAtBeginning();
                case 2 -> addItemAtEnd();
                case 3 -> addItemAtPosition();
                case 4 -> removeItemById();
                case 5 -> updateItemQuantity();
                case 6 -> searchItem();
                case 7 -> displayTotalValue();
                case 8 -> sortInventory();
                case 9 -> inventory.displayInventory();
                case 0 -> System.out.println("Exiting Inventory System...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    /* ---------------- MENU ---------------- */

    static void showMenu() {
        System.out.println("\n===== INVENTORY MANAGEMENT MENU =====");
        System.out.println("1. Add Item at Beginning");
        System.out.println("2. Add Item at End");
        System.out.println("3. Add Item at Position");
        System.out.println("4. Remove Item by ID");
        System.out.println("5. Update Item Quantity");
        System.out.println("6. Search Item");
        System.out.println("7. Calculate Total Inventory Value");
        System.out.println("8. Sort Inventory");
        System.out.println("9. Display Inventory");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    /* ---------------- USER DEFINED FUNCTIONS ---------------- */

    static void addItemAtBeginning() {
    InventoryNode data = readItemData();
        inventory.addAtBeginning(data.itemId, data.itemName, data.quantity, data.price);
    }

    static void addItemAtEnd() {
    	InventoryNode data = readItemData();
        inventory.addAtEnd(data.itemId, data.itemName, data.quantity, data.price);
    }

    static void addItemAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();
        InventoryNode data = readItemData();
        inventory.addAtPosition(pos, data.itemId, data.itemName, data.quantity, data.price);
    }

    static void removeItemById() {
        System.out.print("Enter Item ID to remove: ");
        int id = sc.nextInt();
        inventory.removeByItemId(id);
    }

    static void updateItemQuantity() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();
        System.out.print("Enter new quantity: ");
        int qty = sc.nextInt();
        inventory.updateQuantity(id, qty);
    }

    static void searchItem() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("Enter Item ID: ");
            inventory.searchById(sc.nextInt());
        } else if (ch == 2) {
            System.out.print("Enter Item Name: ");
            inventory.searchByName(sc.nextLine());
        } else {
            System.out.println("Invalid search option");
        }
    }

    static void displayTotalValue() {
        System.out.println("Total Inventory Value: " +
                inventory.calculateTotalInventoryValue());
    }

    static void sortInventory() {
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Price");
        int type = sc.nextInt();

        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int order = sc.nextInt();

        boolean ascending = order == 1;

        if (type == 1) {
            inventory.sortByName(ascending);
        } else if (type == 2) {
            inventory.sortByPrice(ascending);
        } else {
            System.out.println("Invalid sort option");
        }
    }

    /* ---------------- HELPER FUNCTION ---------------- */

    static InventoryNode readItemData() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        return new InventoryNode(id, name, qty, price);
    }
}
