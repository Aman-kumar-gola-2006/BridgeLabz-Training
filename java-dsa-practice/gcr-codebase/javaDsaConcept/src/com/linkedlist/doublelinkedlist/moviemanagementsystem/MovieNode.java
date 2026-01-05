package com.linkedlist.doublylinkedlist.moviemanagementsystem;

public class MovieNode {

    String title;
    String director;
    int yearOfRelease;
    int rating;

    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int yearOfRelease, int rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
