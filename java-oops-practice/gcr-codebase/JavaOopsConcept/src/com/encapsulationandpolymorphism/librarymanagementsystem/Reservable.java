package com.encapsulationandpolymorphism.librarymanagementsystem;

/*
 * Reservable interface
 * --------------------
 * Any library item that can be reserved
 * must implement this interface.
 */
public interface Reservable {

    // Reserves the item if available
    void reserveItem(String borrowerName);

    // Checks whether the item is available
    boolean checkAvailability();
}

