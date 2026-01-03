package com.encapsulationandpolymorphism.ecommerceplatform;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism by processing all products
 * using Product references.
 */
public class Main {

    // Polymorphic method to calculate final price
    public static void printFinalBill(List<Product> products) {

        System.out.println("\n========== FINAL BILL ==========\n");

        for (Product product : products) {

            product.displayBasicDetails();

            double tax = 0;

            // Check if product is taxable
            if (product instanceof Taxable taxableProduct) {
                taxableProduct.getTaxDetails();
                tax = taxableProduct.calculateTax();
            } else {
                System.out.println("Tax Type     : No Tax");
            }

            double discount = product.calculateDiscount();
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Discount     : ₹" + discount);
            System.out.println("Tax Amount   : ₹" + tax);
            System.out.println("Final Price  : ₹" + finalPrice);
            System.out.println("--------------------------------\n");
        }
    }

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        // ---------- Electronics (4 examples) ----------
        productList.add(new Electronics(101, "Laptop", 65000));
        productList.add(new Electronics(102, "Smartphone", 30000));
        productList.add(new Electronics(103, "Headphones", 5000));
        productList.add(new Electronics(104, "Smart TV", 45000));

        // ---------- Clothing (3 examples) ----------
        productList.add(new Clothing(201, "Jeans", 2500));
        productList.add(new Clothing(202, "Jacket", 4000));
        productList.add(new Clothing(203, "T-Shirt", 1200));

        // ---------- Groceries (3 examples) ----------
        productList.add(new Groceries(301, "Rice", 1800));
        productList.add(new Groceries(302, "Milk", 60));
        productList.add(new Groceries(303, "Vegetables", 300));

        // Generate final bill
        printFinalBill(productList);
    }
}
