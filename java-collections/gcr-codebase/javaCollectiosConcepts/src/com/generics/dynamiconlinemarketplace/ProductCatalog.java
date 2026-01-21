package com.generics.dynamiconlinemarketplace;

import java.util.ArrayList;
import java.util.List;

/*
 * Generic Product Catalog class
 * Allows storing multiple product types safely
 */
class ProductCatalog<T extends Product> {

    private List<T> products = new ArrayList<>();

    // Add product to catalog
    public void addProduct(T product) {
        products.add(product);
    }

    // Return all products
    public List<T> getProducts() {
        return products;
    }
}
