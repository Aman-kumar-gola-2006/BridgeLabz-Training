package com.objectmodeling;

import java.util.ArrayList;

public class Library {

	// Library name
	private String libraryName;

	// Aggregation: Library HAS-A list of Books
	private ArrayList<Book> books;

	// Constructor
	public Library(String libraryName) {
		this.libraryName = libraryName;
		this.books = new ArrayList<>();
	}

	// Method to add a book to library
	public void addBook(Book book) {
		books.add(book);
	}

	// Method to display library details
	public void displayLibrary() {
		System.out.println("\nLibrary Name: " + libraryName);
		System.out.println("Books Available:");
		System.out.println("----------------");

		for (Book book : books) {
			book.displayBook();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Library library=new Library("Wisdom Library");
        Book book=new Book("Green Island", "Unknown");
        library.addBook(book);
        library.displayLibrary();
        
        // Added new book into library and displayed the result
        Book bookNew=new Book("Money Bank", "Adam Finn");
        library.addBook(bookNew);
        library.displayLibrary();
        
	}
	
}