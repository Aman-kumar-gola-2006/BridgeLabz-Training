import java.util.Scanner;

class RoboWarehouseInsertionSort {

    // Insertion Sort logic
    static void insertionSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;

            // Shift heavier items to the right
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert current package at correct position
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of packages: ");
        int n = sc.nextInt();

        int weights[] = new int[n];

        System.out.println("Enter package weights one by one:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        // Sorting packages using Insertion Sort
        insertionSort(weights, n);

        // Display shelf order
        System.out.println("\nShelf order (Ascending by Weight):");
        for (int i = 0; i < n; i++) {
            System.out.print(weights[i] + " ");
        }

        sc.close();
    }
}
