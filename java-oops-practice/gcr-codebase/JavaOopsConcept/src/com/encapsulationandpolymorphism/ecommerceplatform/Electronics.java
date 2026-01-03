package com.encapsulationandpolymorphism.ecommerceplatform;

/*
 * Electronics class
 * -----------------
 * Electronics products attract GST and fixed discounts.
 */
public class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Electronics get 10% discount
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    // GST for electronics is 18%
    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax Type     : GST (18%)");
    }
}