package com.encapsulationandpolymorphism.ecommerceplatform;

/*
 * Clothing class
 * --------------
 * Clothing items have higher discounts and moderate tax.
 */
public class Clothing extends Product implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Clothing items get 20% discount
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    // Tax for clothing is 5%
    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax Type     : VAT (5%)");
    }
}
