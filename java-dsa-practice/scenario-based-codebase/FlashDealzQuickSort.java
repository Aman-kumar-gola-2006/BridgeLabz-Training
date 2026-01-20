import java.util.Scanner;

class FlashDealzQuickSort {

    // Partition logic for Quick Sort
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];   // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {    // higher discount first
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
            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int discount[] = new int[n];

        System.out.println("Enter discount percentage for each product:");
        for (int i = 0; i < n; i++) {
            discount[i] = sc.nextInt();
        }

        // Sorting products by discount using Quick Sort
        quickSort(discount, 0, n - 1);

        // Display top discounted products
        System.out.println("\nProducts sorted by Discount (High to Low):");
        for (int i = 0; i < n; i++) {
            System.out.print(discount[i] + "% ");
        }

        sc.close();
    }
}
