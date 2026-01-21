package com.generics.dynamiconlinemarketplace;

import java.util.ArrayList;
import java.util.List;

/*
 * Gadget Product class
 */
class Gadget extends Product {

    private int warrantyYears;

    public Gadget(String name, double price, int warrantyYears) {
        super(name, price, "Gadgets");
        this.warrantyYears = warrantyYears;
    }

    @Override
    public void displayProduct() {
        System.out.println("Gadget: " + name +
                ", Warranty: " + warrantyYears + " years" +
                ", Price: ₹" + price);
    }
}
