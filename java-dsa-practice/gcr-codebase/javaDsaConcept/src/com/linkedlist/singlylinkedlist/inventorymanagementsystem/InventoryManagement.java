package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

public class InventoryManagement {

    private InventoryNode head;

   

    // Add at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
    	InventoryNode newNode = new InventoryNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int id, String name, int qty, double price) {
    	InventoryNode newNode = new InventoryNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        InventoryNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int id, String name, int qty, double price) {
        if (position <= 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        InventoryNode newNode = new InventoryNode(id, name, qty, price);
        InventoryNode temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    /* ---------------- REMOVE ---------------- */

    public void removeByItemId(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        InventoryNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Item not found");
        }
    }

    /* ---------------- UPDATE ---------------- */

    public void updateQuantity(int id, int newQuantity) {
    	InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    /* ---------------- SEARCH ---------------- */

    public void searchById(int id) {
    	InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByName(String name) {
    	InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    /* ---------------- TOTAL VALUE ---------------- */

    public double calculateTotalInventoryValue() {
        double total = 0;
        InventoryNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }

    /* ---------------- DISPLAY ---------------- */

    public void displayInventory() {
    	InventoryNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(InventoryNode item) {
        System.out.println(
            "ID: " + item.itemId +
            ", Name: " + item.itemName +
            ", Qty: " + item.quantity +
            ", Price: " + item.price
        );
    }

    /* ---------------- SORTING (MERGE SORT) ---------------- */

    public void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private InventoryNode mergeSort(InventoryNode node, boolean asc, boolean sortByName) {
        if (node == null || node.next == null) return node;

        InventoryNode middle = getMiddle(node);
        InventoryNode nextOfMiddle = middle.next;
        middle.next = null;

        InventoryNode left = mergeSort(node, asc, sortByName);
        InventoryNode right = mergeSort(nextOfMiddle, asc, sortByName);

        return sortedMerge(left, right, asc, sortByName);
    }

    private InventoryNode sortedMerge(InventoryNode a, InventoryNode b, boolean asc, boolean sortByName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (sortByName) {
            condition = asc
                ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, asc, sortByName);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, asc, sortByName);
            return b;
        }
    }

    private InventoryNode getMiddle(InventoryNode node) {
        if (node == null) return node;

        InventoryNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
