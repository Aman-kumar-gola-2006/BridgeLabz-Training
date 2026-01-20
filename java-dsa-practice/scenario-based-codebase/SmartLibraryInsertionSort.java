import java.util.Scanner;

class SmartLibraryInsertionSort {

    // Insertion Sort logic for strings
    static void insertionSort(String arr[], int n) {

        for (int i = 1; i < n; i++) {
            String current = arr[i];
            int j = i - 1;

            // Shift titles that come after current alphabetically
            while (j >= 0 && arr[j].compareToIgnoreCase(current) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert current book at correct position
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of borrowed books: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        String books[] = new String[n];

        System.out.println("Enter book titles:");
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextLine();
        }

        // Sorting book titles using Insertion Sort
        insertionSort(books, n);

        // Display sorted borrowed book list
        System.out.println("\nBorrowed Books (Alphabetically Sorted):");
        for (int i = 0; i < n; i++) {
            System.out.println(books[i]);
        }

        sc.close();
    }
}
