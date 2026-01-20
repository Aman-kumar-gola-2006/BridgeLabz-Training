import java.util.Scanner;

class CropMonitorQuickSort {

    // Partition logic for Quick Sort
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];   // taking last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
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

        System.out.print("Enter number of sensor readings: ");
        int n = sc.nextInt();

        int timestamps[] = new int[n];

        System.out.println("Enter sensor timestamps (in seconds):");
        for (int i = 0; i < n; i++) {
            timestamps[i] = sc.nextInt();
        }

        // Sorting timestamps using Quick Sort
        quickSort(timestamps, 0, n - 1);

        // Display sorted timestamps
        System.out.println("\nSorted Sensor Data by Timestamp:");
        for (int i = 0; i < n; i++) {
            System.out.print(timestamps[i] + " ");
        }

        sc.close();
    }
}
