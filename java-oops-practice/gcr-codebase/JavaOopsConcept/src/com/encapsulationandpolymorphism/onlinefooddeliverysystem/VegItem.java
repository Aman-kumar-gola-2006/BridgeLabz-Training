package com.encapsulationandpolymorphism.onlinefooddeliverysystem;

/*
 * VegItem class
 * -------------
 * Vegetarian food items have no extra charges.
 */
public class VegItem extends FoodItem implements Discountable {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Simple price calculation
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Veg items get 10% discount
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Discount      : Veg Discount (10%)");
    }
}

