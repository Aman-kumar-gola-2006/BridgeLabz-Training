import java.util.Scanner;

class FoodFestMergeSort {

    // Merge two sorted parts of the array
    static void merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Stable merge (higher footfall first)
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Merge Sort logic
    static void mergeSort(int arr[], int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of zones: ");
        int zones = sc.nextInt();

        System.out.print("Enter number of stalls per zone: ");
        int stallsPerZone = sc.nextInt();

        int totalStalls = zones * stallsPerZone;
        int footfall[] = new int[totalStalls];

        int index = 0;

        // Taking zone-wise sorted footfall data
        for (int i = 1; i <= zones; i++) {
            System.out.println("Enter sorted footfall data for Zone " + i + ":");
            for (int j = 0; j < stallsPerZone; j++) {
                footfall[index] = sc.nextInt();
                index++;
            }
        }

        // Combine all zones using Merge Sort
        mergeSort(footfall, 0, footfall.length - 1);

        // Display master stall performance list
        System.out.println("\nMaster Stall Footfall List:");
        for (int i = 0; i < footfall.length; i++) {
            System.out.println("Rank " + (i + 1) + " : " + footfall[i] + " customers");
        }

        sc.close();
    }
}
