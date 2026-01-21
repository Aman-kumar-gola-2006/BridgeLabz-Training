package com.generics.smartwarehousemanagement;

class Furniture extends WarehouseItem {

    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    // Display details of furniture item
    @Override
    public void displayItem() {
        System.out.println("Furniture Item: " + name +
                ", Price: ₹" + price +
                ", Material: " + material);
    }
}