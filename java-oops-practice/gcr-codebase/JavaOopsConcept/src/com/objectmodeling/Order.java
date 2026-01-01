package com.objectmodeling;

import java.util.ArrayList;

/**
* Order class
* Aggregates multiple products
*/
class Order {

   private ArrayList<Product> products = new ArrayList<>();

   // Add product to order
   public void addProduct(Product product) {
       products.add(product);
   }

   // Display order details
   public void displayOrder() {
       System.out.println("Order contains:");
       for (Product product : products) {
           System.out.println("- " + product.getProductDetails());
       }
   }
}