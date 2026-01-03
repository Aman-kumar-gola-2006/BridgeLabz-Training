package com.encapsulationandpolymorphism.librarymanagementsystem;

/*
 * Abstract LibraryItem class
 * --------------------------
 * Acts as a base class for all library items.
 * Uses encapsulation to protect borrower details.
 */
public abstract class LibraryItem {

    // Encapsulated item details
    private int itemId;
    private String title;
    private String author;

    // Sensitive borrower data (restricted access)
    private String borrowedBy;
    private boolean isAvailable = true;

    // Constructor to initialize common item data
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method for loan duration
    public abstract int getLoanDuration();

    // Protected access for subclasses
    protected boolean isAvailable() {
        return isAvailable;
    }

    protected void markBorrowed(String borrowerName) {
        this.borrowedBy = borrowerName;
        this.isAvailable = false;
    }

    protected void markReturned() {
        this.borrowedBy = null;
        this.isAvailable = true;
    }

    // Displays basic item details
    public void getItemDetails() {
        System.out.println("Item ID        : " + itemId);
        System.out.println("Title          : " + title);
        System.out.println("Author         : " + author);
        System.out.println("Availability   : " + (isAvailable ? "Available" : "Issued"));
    }

    // Borrower details are never directly exposed
    protected String getMaskedBorrower() {
        return borrowedBy == null ? "N/A" : borrowedBy.charAt(0) + "*****";
    }
}

