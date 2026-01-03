package com.encapsulationandpolymorphism.librarymanagementsystem;

/*
 * DVD class
 * ---------
 * DVDs have the shortest loan duration.
 */
public class DVD extends LibraryItem implements Reservable {

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    // DVDs can be borrowed for 3 days
    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            markBorrowed(borrowerName);
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is currently unavailable.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

