package com.encapsulationandpolymorphism.librarymanagementsystem;


/*
 * Magazine class
 * --------------
 * Magazines have a shorter loan period.
 */
public class Magazine extends LibraryItem implements Reservable {

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Magazines can be borrowed for 7 days
    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            markBorrowed(borrowerName);
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is currently unavailable.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
