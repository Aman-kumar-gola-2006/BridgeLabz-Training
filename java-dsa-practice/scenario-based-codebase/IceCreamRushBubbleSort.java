import java.util.Scanner;

class IceCreamRushBubbleSort {

    // Bubble Sort logic
    static void bubbleSort(int arr[], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                // Swap if current sales count is less than next
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of ice cream flavors: ");
        int n = sc.nextInt();

        int sales[] = new int[n];

        System.out.println("Enter weekly sales count for each flavor:");
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }

        // Sorting flavors by popularity using Bubble Sort
        bubbleSort(sales, n);

        // Display sorted popularity list
        System.out.println("\nFlavors sorted by popularity (Highest to Lowest):");
        for (int i = 0; i < n; i++) {
            System.out.print(sales[i] + " ");
        }

        sc.close();
    }
}
