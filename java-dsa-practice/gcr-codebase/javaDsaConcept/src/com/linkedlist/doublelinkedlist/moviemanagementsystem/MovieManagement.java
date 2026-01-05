package com.linkedlist.doublylinkedlist.moviemanagementsystem;

public class MovieManagement {

    private MovieNode head;
    private MovieNode tail;

    // Insert at beginning
    public void insertAtBeginning(String title, String director, int year, int rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie inserted at beginning.");
    }

    // Insert at end
    public void insertAtEnd(String title, String director, int year, int rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        System.out.println("Movie inserted at end.");
    }

    // Insert at specific position
    public void insertAtPosition(int pos, String title, String director, int year, int rating) {
        if (pos <= 0) {
            insertAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            insertAtEnd(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;

        if (newNode.next == null)
            tail = newNode;

        System.out.println("Movie inserted at position " + pos);
    }

    // Delete by movie title
    public void deleteByTitle(String title) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {

                if (temp == head)
                    head = temp.next;

                if (temp == tail)
                    tail = temp.prev;

                if (temp.prev != null)
                    temp.prev.next = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;

                System.out.println("Movie deleted successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by Director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayNode(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director.");
    }

    // Search by Rating
    public void searchByRating(int rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayNode(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating.");
    }

    // Update rating by title
    public void updateRating(String title, int newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            displayNode(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            displayNode(temp);
            temp = temp.prev;
        }
    }

    private void displayNode(MovieNode m) {
        System.out.println("Title: " + m.title +
                ", Director: " + m.director +
                ", Year: " + m.yearOfRelease +
                ", Rating: " + m.rating);
    }
}
