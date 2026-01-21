package com.generics.smartwarehousemanagement;

class Electronics extends WarehouseItem {

    private int warrantyYears;

    public Electronics(String name, double price, int warrantyYears) {
        super(name, price);
        this.warrantyYears = warrantyYears;
    }

    // Display details of electronic item
    @Override
    public void displayItem() {
        System.out.println("Electronics Item: " + name +
                ", Price: ₹" + price +
                ", Warranty: " + warrantyYears + " years");
    }
}