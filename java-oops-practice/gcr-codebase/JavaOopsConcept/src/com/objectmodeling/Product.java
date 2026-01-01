package com.objectmodeling;


/**
 * Product class
 * Independent entity
 */
class Product {

    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductDetails() {
        return productName + " (₹" + price + ")";
    }
}