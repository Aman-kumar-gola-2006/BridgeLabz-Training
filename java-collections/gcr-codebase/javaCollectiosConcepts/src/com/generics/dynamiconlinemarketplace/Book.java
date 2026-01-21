package com.generics.dynamiconlinemarketplace;

/*
 * Book Product class
 */
class Book extends Product {

    private String author;

    public Book(String name, double price, String author) {
        super(name, price, "Books");
        this.author = author;
    }

    @Override
    public void displayProduct() {
        System.out.println("Book: " + name +
                ", Author: " + author +
                ", Price: ₹" + price);
    }
}
