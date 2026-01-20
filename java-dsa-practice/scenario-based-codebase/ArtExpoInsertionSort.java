import java.util.Scanner;

class ArtExpoInsertionSort {

    // Insertion Sort logic
    static void insertionSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;

            // Shift later registration times to the right
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place current time at correct position
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of artists registered: ");
        int n = sc.nextInt();

        int regTime[] = new int[n];

        System.out.println("Enter registration times (in minutes):");
        for (int i = 0; i < n; i++) {
            regTime[i] = sc.nextInt();
        }

        // Sorting registration times using Insertion Sort
        insertionSort(regTime, n);

        // Display sorted registration list
        System.out.println("\nArtists sorted by Registration Time:");
        for (int i = 0; i < n; i++) {
            System.out.print(regTime[i] + " ");
        }

        sc.close();
    }
}
