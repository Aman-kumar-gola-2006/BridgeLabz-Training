package com.generics.smartwarehousemanagement;

import java.util.*;

public class Main {

	/*
     * Wildcard method to display items from any type of storage
     * ? extends WarehouseItem allows reading items safely
     */
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayItem();
        }
    }

    public static void main(String[] args) {

        // Creating storage for Electronics
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 75000, 2));
        electronicsStorage.addItem(new Electronics("Smartphone", 35000, 1));

        // Creating storage for Groceries
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice", 1200, "12-2025"));
        groceryStorage.addItem(new Groceries("Milk", 50, "02-2026"));

        // Creating storage for Furniture
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 2500, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 8000, "Metal"));

        // Displaying all items using wildcard method
        System.out.println("---- Electronics Storage ----");
        displayAllItems(electronicsStorage.getItems());

        System.out.println("\n---- Grocery Storage ----");
        displayAllItems(groceryStorage.getItems());

        System.out.println("\n---- Furniture Storage ----");
        displayAllItems(furnitureStorage.getItems());
    }
}