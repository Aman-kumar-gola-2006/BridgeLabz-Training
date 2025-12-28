package com.javaconstructors.level1;

public class books {

	 // Public variable (accessible everywhere)
    public String ISBN;

    // Protected variable (accessible in subclass)
    protected String title;

    // Private variable (accessible only using methods)
    private String author;

    // Public constructor to initialize book details
    public books(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set author name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get author name
    public String getAuthor() {
        return author;
    }
}