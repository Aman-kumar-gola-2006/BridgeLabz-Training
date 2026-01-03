package com.encapsulationandpolymorphism.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism by managing
 * different library items using LibraryItem references.
 */
public class Main {

    // Polymorphic method to display and reserve items
    public static void processLibraryItems(List<LibraryItem> items) {

        System.out.println("\n========== LIBRARY ITEM SUMMARY ==========\n");

        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration  : " + item.getLoanDuration() + " days");

            if (item instanceof Reservable reservableItem) {
                reservableItem.reserveItem("Abhay");
                System.out.println("Available Now  : " + reservableItem.checkAvailability());
            }

            System.out.println("------------------------------------------\n");
        }
    }

    public static void main(String[] args) {

        List<LibraryItem> libraryItems = new ArrayList<>();

        // -------- Books (3 examples) --------
        libraryItems.add(new Book(101, "Clean Code", "Robert Martin"));
        libraryItems.add(new Book(102, "Effective Java", "Joshua Bloch"));
        libraryItems.add(new Book(103, "Java: The Complete Reference", "Herbert Schildt"));

        // -------- Magazines (3 examples) --------
        libraryItems.add(new Magazine(201, "Time", "Time Editors"));
        libraryItems.add(new Magazine(202, "Forbes", "Forbes Media"));
        libraryItems.add(new Magazine(203, "National Geographic", "NG Society"));

        // -------- DVDs (3 examples) --------
        libraryItems.add(new DVD(301, "Inception", "Christopher Nolan"));
        libraryItems.add(new DVD(302, "Interstellar", "Christopher Nolan"));
        libraryItems.add(new DVD(303, "The Matrix", "Wachowskis"));

        // Process all items polymorphically
        processLibraryItems(libraryItems);
    }
}

