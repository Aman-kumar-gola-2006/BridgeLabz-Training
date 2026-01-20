import java.util.Scanner;

class CinemaHouseBubbleSort {

    // Bubble Sort logic
    static void bubbleSort(int arr[], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                // Swap if current time is greater than next time
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movie shows (max 10): ");
        int n = sc.nextInt();

        int showTime[] = new int[n];

        System.out.println("Enter show timings (in hours, e.g. 10 for 10AM, 18 for 6PM):");
        for (int i = 0; i < n; i++) {
            showTime[i] = sc.nextInt();
        }

        // Sorting show timings using Bubble Sort
        bubbleSort(showTime, n);

        // Display sorted movie timings
        System.out.println("\nSorted Movie Show Timings:");
        for (int i = 0; i < n; i++) {
            System.out.print(showTime[i] + " ");
        }

        sc.close();
    }
}
