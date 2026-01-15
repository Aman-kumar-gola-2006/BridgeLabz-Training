import java.util.*;

public class SmartShelf {

    // Insertion Sort for book titles (alphabetical order)
    public static void insertionSort(String[] arr, int n) {
        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;

            // Shift larger titles to the right
            while (j >= 0 && arr[j].compareToIgnoreCase(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert book in correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] books = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter book title " + (i + 1) + ": ");
            books[i] = sc.nextLine();

            // Sort only the portion added so far
            insertionSort(books, i + 1);

            System.out.println("Current sorted reading list:");
            for (int k = 0; k <= i; k++) {
                System.out.println(" - " + books[k]);
            }
            System.out.println();
        }

        System.out.println("\nFinal Sorted Book List:");
        for (String b : books) {
            System.out.println(" - " + b);
        }
    }
}
