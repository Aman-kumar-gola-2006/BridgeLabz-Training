import java.util.Scanner;

class MovieTimeInsertionSort {

    // Insertion Sort logic for showtimes
    static void insertionSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {
            int currentTime = arr[i];
            int j = i - 1;

            // Shift later times to the right
            while (j >= 0 && arr[j] > currentTime) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert current showtime at correct position
            arr[j + 1] = currentTime;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movie shows: ");
        int n = sc.nextInt();

        int showTimes[] = new int[n];

        System.out.println("Enter showtimes (in 24-hour format, e.g., 1430 for 2:30 PM):");
        for (int i = 0; i < n; i++) {
            showTimes[i] = sc.nextInt();
        }

        // Sorting showtimes using Insertion Sort
        insertionSort(showTimes, n);

        // Display sorted showtimes
        System.out.println("\nSorted Movie Showtimes:");
        for (int i = 0; i < n; i++) {
            System.out.print(showTimes[i] + " ");
        }

        sc.close();
    }
}
