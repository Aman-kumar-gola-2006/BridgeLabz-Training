package com.encapsulationandpolymorphism.onlinefooddeliverysystem;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism by processing
 * different food items using FoodItem references.
 */
public class Main {

    // Polymorphic order processing method
    public static void processOrder(List<FoodItem> orderItems) {

        double grandTotal = 0;

        System.out.println("\n========== FOOD ORDER SUMMARY ==========\n");

        for (FoodItem item : orderItems) {

            item.getItemDetails();

            double totalPrice = item.calculateTotalPrice();
            double discount = 0;

            // Apply discount if supported
            if (item instanceof Discountable discountableItem) {
                discountableItem.getDiscountDetails();
                discount = discountableItem.applyDiscount();
            }

            double finalPrice = totalPrice - discount;
            grandTotal += finalPrice;

            System.out.println("Item Total    : ₹" + totalPrice);
            System.out.println("Discount Amt  : ₹" + discount);
            System.out.println("Final Price  : ₹" + finalPrice);
            System.out.println("----------------------------------------\n");
        }

        System.out.println("Grand Total Amount: ₹" + grandTotal);
    }

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        // -------- Veg Items (4 examples) --------
        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new VegItem("Veg Biryani", 180, 1));
        order.add(new VegItem("Masala Dosa", 120, 3));
        order.add(new VegItem("Veg Burger", 90, 2));

        // -------- Non-Veg Items (4 examples) --------
        order.add(new NonVegItem("Chicken Biryani", 280, 2));
        order.add(new NonVegItem("Chicken Burger", 150, 1));
        order.add(new NonVegItem("Mutton Curry", 350, 1));
        order.add(new NonVegItem("Fish Fry", 220, 2));

        // Process the complete order
        processOrder(order);
    }
}

