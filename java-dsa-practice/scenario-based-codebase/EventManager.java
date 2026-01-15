import java.util.*;

public class EventManager {

    // Quick Sort Method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partition index
            quickSort(arr, low, pi - 1);        // left side
            quickSort(arr, pi + 1, high);       // right side
        }
    }

    // Partition Method
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];    // choosing last element as pivot
        int i = low - 1;          // pointer for smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {    // put smaller elements left
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot to correct location
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // pivot index
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // User inputs ticket prices
        for (int i = 0; i < n; i++) {
            System.out.print("Enter ticket price " + (i + 1) + ": ");
            prices[i] = sc.nextInt();
        }

        // Sort using Quick Sort
        quickSort(prices, 0, n - 1);

        System.out.println("\nSorted Ticket Prices (Low to High):");
        for (int p : prices) {
            System.out.print(p + " ");
        }

        // Show top 5 cheapest & most expensive for demo
        System.out.println("\n\nTop 5 Cheapest:");
        for (int i = 0; i < Math.min(5, n); i++) {
            System.out.println(prices[i]);
        }

        System.out.println("\nTop 5 Most Expensive:");
        for (int i = n - 1; i >= Math.max(0, n - 5); i--) {
            System.out.println(prices[i]);
        }
    }
}
