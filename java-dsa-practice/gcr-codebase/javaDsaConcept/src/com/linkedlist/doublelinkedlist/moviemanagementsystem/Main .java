package com.linkedlist.doublylinkedlist.moviemanagementsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MovieManagement movie = new MovieManagement();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n----- MOVIE MANAGEMENT MENU -----");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Delete Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    int rating = sc.nextInt();

                    movie.insertAtBeginning(title, director, year, rating);
                }

                case 2 -> {
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    int rating = sc.nextInt();

                    movie.insertAtEnd(title, director, year, rating);
                }

                case 3 -> {
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    int rating = sc.nextInt();

                    movie.insertAtPosition(pos, title, director, year, rating);
                }

                case 4 -> {
                    System.out.print("Enter Movie Title to Delete: ");
                    String title = sc.nextLine();
                    movie.deleteByTitle(title);
                }

                case 5 -> {
                    System.out.print("Enter Director Name: ");
                    String director = sc.nextLine();
                    movie.searchByDirector(director);
                }

                case 6 -> {
                    System.out.print("Enter Rating: ");
                    int rating = sc.nextInt();
                    movie.searchByRating(rating);
                }

                case 7 -> {
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    int rating = sc.nextInt();
                    movie.updateRating(title, rating);
                }

                case 8 -> movie.displayForward();

                case 9 -> movie.displayReverse();

                case 10 -> System.out.println("Exiting Movie Management System...");

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 10);

        sc.close();
    }
}
