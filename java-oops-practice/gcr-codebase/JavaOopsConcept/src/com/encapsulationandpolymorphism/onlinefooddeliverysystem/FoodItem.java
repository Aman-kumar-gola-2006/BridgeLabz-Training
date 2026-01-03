package com.encapsulationandpolymorphism.onlinefooddeliverysystem;


/*
 * Abstract FoodItem class
 * -----------------------
 * Serves as a base class for all food items.
 * Uses encapsulation to protect order details.
 */
public abstract class FoodItem {

    // Encapsulated fields
    private String itemName;
    private double price;
    private int quantity;

    // Constructor initializes common food item data
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Read-only access using getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Controlled setter for quantity
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    /*
     * Abstract method to calculate total price.
     * Implemented differently by Veg and Non-Veg items.
     */
    public abstract double calculateTotalPrice();

    // Displays basic item details
    public void getItemDetails() {
        System.out.println("Item Name     : " + itemName);
        System.out.println("Price (each)  : ₹" + price);
        System.out.println("Quantity      : " + quantity);
    }
}

