package com.generics.dynamiconlinemarketplace;

/*
 * Clothing Product class
 */
class Clothing extends Product {

    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price, "Clothing");
        this.size = size;
    }

    @Override
    public void displayProduct() {
        System.out.println("Clothing: " + name +
                ", Size: " + size +
                ", Price: ₹" + price);
    }
}
