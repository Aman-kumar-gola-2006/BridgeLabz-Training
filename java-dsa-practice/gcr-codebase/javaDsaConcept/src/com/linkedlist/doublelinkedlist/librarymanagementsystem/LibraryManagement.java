package com.linkedlist.doublylinkedlist.librarymanagementsystem;

public class LibraryManagement {

    private BookNode head;
    private BookNode tail;

    // Add at beginning
    public void addAtBeginning(int id, String title, String author, String genre, boolean status) {
        BookNode newBook = new BookNode(id, title, author, genre, status);

        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add at end
    public void addAtEnd(int id, String title, String author, String genre, boolean status) {
        BookNode newBook = new BookNode(id, title, author, genre, status);

        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean status) {
        if (pos <= 1) {
            addAtBeginning(id, title, author, genre, status);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, status);
            return;
        }

        BookNode newBook = new BookNode(id, title, author, genre, status);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

   
    public void removeByBookId(int id) {
        if (head == null) return;

        BookNode temp = head;

        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed successfully");
    }

    public void searchByTitle(String title) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found for this author");
        }
    }


    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }


    public void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }


    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    private void displayBook(BookNode b) {
        System.out.println(
                "ID: " + b.bookId +
                ", Title: " + b.title +
                ", Author: " + b.author +
                ", Genre: " + b.genre +
                ", Available: " + (b.isAvailable ? "Yes" : "No")
        );
    }
    }