package com.encapsulationandpolymorphism.librarymanagementsystem;

/*
 * Book class
 * ----------
 * Books can be borrowed for a longer duration.
 */
public class Book extends LibraryItem implements Reservable {

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Books can be borrowed for 14 days
    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            markBorrowed(borrowerName);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is currently unavailable.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

