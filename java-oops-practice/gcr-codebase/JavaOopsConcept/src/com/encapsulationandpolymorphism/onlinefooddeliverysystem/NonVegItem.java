package com.encapsulationandpolymorphism.onlinefooddeliverysystem;

/*
 * NonVegItem class
 * ----------------
 * Non-vegetarian items include extra handling charges.
 */
public class NonVegItem extends FoodItem implements Discountable {

    private static final double NON_VEG_CHARGE = 50;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Includes extra non-veg handling charge
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_CHARGE;
    }

    // Non-veg items get 5% discount
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Discount      : Non-Veg Discount (5%)");
        System.out.println("Extra Charge  : ₹" + NON_VEG_CHARGE);
    }
}

