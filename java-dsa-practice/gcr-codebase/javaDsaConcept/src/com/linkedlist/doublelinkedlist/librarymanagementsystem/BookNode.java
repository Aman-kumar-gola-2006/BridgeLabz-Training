package com.linkedlist.doublylinkedlist.librarymanagementsystem;

class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;

    BookNode next;
    BookNode prev;

    public BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}