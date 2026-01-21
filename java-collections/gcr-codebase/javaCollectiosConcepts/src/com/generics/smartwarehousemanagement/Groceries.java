package com.generics.smartwarehousemanagement;

class Groceries extends WarehouseItem {

    private String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    // Display details of grocery item
    @Override
    public void displayItem() {
        System.out.println("Grocery Item: " + name +
                ", Price: ₹" + price +
                ", Expiry Date: " + expiryDate);
    }
}