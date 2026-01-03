package com.encapsulationandpolymorphism.onlinefooddeliverysystem;

/*
 * Discountable interface
 * ----------------------
 * Any food item that supports discounts
 * must implement this interface.
 */
public interface Discountable {

    // Applies discount and returns discount amount
    double applyDiscount();

    // Displays discount-related details
    void getDiscountDetails();
}
