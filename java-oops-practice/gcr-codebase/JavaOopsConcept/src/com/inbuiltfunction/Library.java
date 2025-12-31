package com.inbuiltfunction;

public class Library {
	   public static void main(String[] args) {
	       // Set the library name (static variable)
	       book.setLibraryName("Egmore Library");
	       // Display the library name
	       book.displayLibraryName();
	       // Create a new book instance
	       book book1 = new book("Effective Java", "Joshua Bloch", "978-0134685991");
	       // Display book details
	       book1.displayBookDetails();
	   }
	}