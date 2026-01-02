package com.inheritance.singleinheritence.librarymanagement;

public class Main {
	public static void main(String[] args) {

        Author book1 = new Author(
            "Java Programming",
            2022,
            "James Gosling",
            "Father of the Java programming language"
        );

        book1.displayInfo();
}
	}