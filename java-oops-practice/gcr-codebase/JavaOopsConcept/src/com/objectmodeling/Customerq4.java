package com.objectmodeling;

import java.util.ArrayList;

/**
 * E-commerce Platform
 * -------------------
 * Customer places Orders
 * Order aggregates Products
 */
class Customerq4 {

    private String customerName;
    private ArrayList<Order> orders;

    public Customerq4(String customerName) {
        this.customerName = customerName;
        this.orders = new ArrayList<>();
    }

    // Customer places an order
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(customerName + " placed an order.");
    }

    // View customer orders
    public void viewOrders() {
        System.out.println("\nOrders placed by " + customerName + ":");
        for (Order order : orders) {
            order.displayOrder();
        }
    }

    public static void main(String[] args) {

        // Create customer
        Customerq4 customer = new Customerq4("Amit");

        // Create products
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 800);

        // Create order
        Order order = new Order();
        order.addProduct(p1);
        order.addProduct(p2);

        // Customer places order
        customer.placeOrder(order);

        // View orders
        customer.viewOrders();
    }
}