package com.encapsulationandpolymorphism.ecommerceplatform;

/*
 * Groceries class
 * ---------------
 * Essential items with minimal discounts and no tax.
 */
public class Groceries extends Product {

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Flat 5% discount on groceries
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}
