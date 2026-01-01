package com.objectmodeling;

public class Book {

	// Attributes of Book
	private String title;
	private String author;

	// Constructor
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// Method to display book details
	public void displayBook() {
		System.out.println("Title  : " + title);
		System.out.println("Author : " + author);
	}
	
}