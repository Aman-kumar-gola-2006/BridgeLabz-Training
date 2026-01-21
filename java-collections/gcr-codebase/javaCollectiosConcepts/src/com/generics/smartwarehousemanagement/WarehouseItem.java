package com.generics.smartwarehousemanagement;

abstract class WarehouseItem {

    protected String name;
    protected double price;

    // Constructor to initialize common item properties
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Abstract method to display item details
    // Each subclass must implement this method
    public abstract void displayItem();
}