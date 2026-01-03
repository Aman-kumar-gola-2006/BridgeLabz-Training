package com.encapsulationandpolymorphism.ecommerceplatform;

/*
 * Taxable interface
 * -----------------
 * Any product that attracts tax must implement this interface.
 * It enforces tax calculation rules across product categories.
 */
public interface Taxable {

    // Calculates tax amount for the product
    double calculateTax();

    // Displays tax-related information
    void getTaxDetails();
}

