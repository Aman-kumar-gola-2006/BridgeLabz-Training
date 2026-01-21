package com.generics.dynamiconlinemarketplace;

import java.util.ArrayList;
import java.util.List;

/*
 * Base abstract Product class
 * All product types (Book, Clothing, Gadget) will extend this class
 */
abstract class Product {

    protected String name;
    protected double price;
    protected String category;

    // Constructor to initialize common fields
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Method to apply discount to product price
    public void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }

    // Abstract method to display product details
    public abstract void displayProduct();
}
