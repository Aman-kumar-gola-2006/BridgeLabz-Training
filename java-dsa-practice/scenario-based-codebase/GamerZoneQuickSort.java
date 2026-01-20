import java.util.Scanner;

class GamerZoneQuickSort {

    // Partition logic for Quick Sort
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];   // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Higher score should come first
            if (arr[j] > pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort logic
    static void quickSort(int arr[], int low, int high) {

        if (low < high) {
            int pos = partition(arr, low, high);

            quickSort(arr, low, pos - 1);
            quickSort(arr, pos + 1, high);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        int scores[] = new int[n];

        System.out.println("Enter player scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Sorting scores using Quick Sort
        quickSort(scores, 0, n - 1);

        // Display leaderboard
        System.out.println("\nGame Leaderboard:");
        for (int i = 0; i < n; i++) {
            System.out.println("Rank " + (i + 1) + " : " + scores[i]);
        }

        sc.close();
    }
}
