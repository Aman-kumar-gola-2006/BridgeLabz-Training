package com.encapsulationandpolymorphism.ecommerceplatform;

/*
 * Abstract Product class
 * ----------------------
 * Acts as a blueprint for all products in the platform.
 * Uses encapsulation to protect product details.
 */
public abstract class Product {

    // Encapsulated fields (private for data safety)
    private int productId;
    private String name;
    private double price;

    // Constructor to initialize common product data
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters (read-only access)
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setter allows controlled update of price
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    /*
     * Abstract discount calculation
     * Each product category defines its own discount logic
     */
    public abstract double calculateDiscount();

    // Displays common product details
    public void displayBasicDetails() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + name);
        System.out.println("Base Price   : ₹" + price);
    }
}