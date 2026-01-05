package com.linkedlist.doublylinkedlist.librarymanagementsystem;
import java.util.*;
public class Main {

	    static Scanner sc = new Scanner(System.in);
	    static LibraryManagement library = new LibraryManagement();

	    public static void main(String[] args) {

	        int choice;
	        do {
	            menu();
	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1 -> addBookBeginning();
	                case 2 -> addBookEnd();
	                case 3 -> addBookPosition();
	                case 4 -> removeBook();
	                case 5 -> searchBook();
	                case 6 -> updateStatus();
	                case 7 -> library.displayForward();
	                case 8 -> library.displayReverse();
	                case 9 -> System.out.println("Total Books: " + library.countBooks());
	                case 0 -> System.out.println("Exiting Library System...");
	                default -> System.out.println("Invalid choice");
	            }
	        } while (choice != 0);
	    }

	    static void menu() {
	        System.out.println("\n--- LIBRARY MANAGEMENT MENU ---");
	        System.out.println("1. Add Book at Beginning");
	        System.out.println("2. Add Book at End");
	        System.out.println("3. Add Book at Position");
	        System.out.println("4. Remove Book by ID");
	        System.out.println("5. Search Book");
	        System.out.println("6. Update Availability");
	        System.out.println("7. Display Books (Forward)");
	        System.out.println("8. Display Books (Reverse)");
	        System.out.println("9. Count Books");
	        System.out.println("0. Exit");
	        System.out.print("Enter choice: ");
	    }

	    static void addBookBeginning() {
	        BookNode b = readBook();
	        library.addAtBeginning(b.bookId, b.title, b.author, b.genre, b.isAvailable);
	    }

	    static void addBookEnd() {
	        BookNode b = readBook();
	        library.addAtEnd(b.bookId, b.title, b.author, b.genre, b.isAvailable);
	    }

	    static void addBookPosition() {
	        System.out.print("Enter position: ");
	        int pos = sc.nextInt();
	        sc.nextLine();
	        BookNode b = readBook();
	        library.addAtPosition(pos, b.bookId, b.title, b.author, b.genre, b.isAvailable);
	    }

	    static void removeBook() {
	        System.out.print("Enter Book ID: ");
	        library.removeByBookId(sc.nextInt());
	    }

	    static void searchBook() {
	        System.out.println("1. Search by Title\n2. Search by Author");
	        int ch = sc.nextInt();
	        sc.nextLine();

	        if (ch == 1) {
	            System.out.print("Enter title: ");
	            library.searchByTitle(sc.nextLine());
	        } else {
	            System.out.print("Enter author: ");
	            library.searchByAuthor(sc.nextLine());
	        }
	    }

	    static void updateStatus() {
	        System.out.print("Enter Book ID: ");
	        int id = sc.nextInt();
	        System.out.print("Available (true/false): ");
	        boolean status = sc.nextBoolean();
	        library.updateAvailability(id, status);
	    }

	    static BookNode readBook() {
	        System.out.print("Book ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Title: ");
	        String title = sc.nextLine();
	        System.out.print("Author: ");
	        String author = sc.nextLine();
	        System.out.print("Genre: ");
	        String genre = sc.nextLine();
	        System.out.print("Available (true/false): ");
	        boolean status = sc.nextBoolean();

	        return new BookNode(id, title, author, genre, status);
	    }
	}


