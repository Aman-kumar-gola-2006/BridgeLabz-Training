package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

public class InventoryNode {
	

	   int itemId;
	    String itemName;
	    int quantity;
	    double price;
	    InventoryNode next;

	    public InventoryNode(int itemId, String itemName, int quantity, double price) {
	        this.itemId = itemId;
	        this.itemName = itemName;
	        this.quantity = quantity;
	        this.price = price;
	        this.next = null;
	    }
	}
