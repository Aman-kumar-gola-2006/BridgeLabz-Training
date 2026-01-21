package com.generics.dynamiconlinemarketplace;

public class Main {
	public static void main(String[] args) {

        // Creating a catalog that can store any Product type
        ProductCatalog<Product> catalog = new ProductCatalog<>();

        // Creating different product types
        Book book = new Book("Java Programming", 650, "James Gosling");
        Clothing shirt = new Clothing("T-Shirt", 1200, "M");
        Gadget phone = new Gadget("Smartphone", 30000, 2);

        // Adding products to catalog
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        // Applying discounts using generic method
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);

        // Displaying all products
        System.out.println("---- Product Catalog ----");
        for (Product product : catalog.getProducts()) {
            product.displayProduct();
        }
    }
}
