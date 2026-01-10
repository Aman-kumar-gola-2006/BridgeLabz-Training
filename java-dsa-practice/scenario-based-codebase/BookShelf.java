import java.util.*;

public class BookShelf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // HashMap for genre → LinkedList of Books
        HashMap<String, LinkedList<String>> library = new HashMap<>();

        // HashSet to avoid duplication of books
        HashSet<String> uniqueBooks = new HashSet<>();

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Show Complete Catalog");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();   // consume nextLine

            switch (choice) {

                case 1:  // Add Book
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine().trim();

                    System.out.print("Enter Book Name: ");
                    String book = sc.nextLine().trim();

                    // Check duplicate using HashSet
                    if (uniqueBooks.contains(book)) {
                        System.out.println("This book already exists in the library. Duplicate not allowed.");
                    } else {
                        // If genre not present → create new LinkedList
                        library.putIfAbsent(genre, new LinkedList<>());

                        // Add book to the LinkedList
                        library.get(genre).add(book);

                        // Add book to HashSet
                        uniqueBooks.add(book);

                        System.out.println("Book added successfully.");
                    }
                    break;

                case 2:  // Remove Book
                    System.out.print("Enter Genre: ");
                    String rGenre = sc.nextLine().trim();

                    System.out.print("Enter Book Name: ");
                    String rBook = sc.nextLine().trim();

                    if (library.containsKey(rGenre)) {
                        LinkedList<String> list = library.get(rGenre);

                        if (list.remove(rBook)) {
                            uniqueBooks.remove(rBook);
                            System.out.println("Book removed successfully.");
                        } else {
                            System.out.println("Book not found under this genre.");
                        }

                    } else {
                        System.out.println("Genre not found.");
                    }
                    break;

                case 3:  // Show Catalog
                    System.out.println("\n===== Library Catalog =====");
                    if (library.isEmpty()) {
                        System.out.println("Library is empty.");
                    } else {
                        for (Map.Entry<String, LinkedList<String>> entry : library.entrySet()) {
                            System.out.println("Genre: " + entry.getKey());
                            System.out.println("Books: " + entry.getValue());
                            System.out.println();
                        }
                    }
                    break;

                case 4:  // Exit
                    System.out.println("Exiting Library System...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
