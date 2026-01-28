package com.mapinterface.shoppingcart;

import java.util.*;

public class ShoppingCart {

    // HashMap: stores product prices
    Map<String, Integer> productPrices = new HashMap<>();

    // LinkedHashMap: maintains order of items added to cart
    Map<String, Integer> cartItems = new LinkedHashMap<>();

    // Add product with price
    public void addProduct(String product, int price) {
        productPrices.put(product, price);
    }

    // Add item to cart
    public void addToCart(String product) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, productPrices.get(product));
        }
    }

    // Display cart in insertion order
    public void showCart() {
        System.out.println("Cart Items (Insertion Order): " + cartItems);
    }

    // Display cart sorted by price
    public void showCartSortedByPrice() {
        TreeMap<Integer, List<String>> sorted = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            int price = entry.getValue();
            sorted.putIfAbsent(price, new ArrayList<>());
            sorted.get(price).add(entry.getKey());
        }

        System.out.println("Cart Items (Sorted by Price): " + sorted);
    }

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 50000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1500);

        cart.addToCart("Laptop");
        cart.addToCart("Mouse");
        cart.addToCart("Keyboard");

        cart.showCart();
        cart.showCartSortedByPrice();
    }
}
