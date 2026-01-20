import java.util.Scanner;

class FleetManagerMergeSort {

    // Merge two sorted parts of the array
    static void merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {   // lower mileage first
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
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

        System.out.print("Enter number of depots: ");
        int depots = sc.nextInt();

        System.out.print("Enter vehicles per depot: ");
        int vehiclesPerDepot = sc.nextInt();

        int totalVehicles = depots * vehiclesPerDepot;
        int mileage[] = new int[totalVehicles];

        int index = 0;

        // Taking sorted mileage input depot-wise
        for (int i = 1; i <= depots; i++) {
            System.out.println("Enter sorted vehicle mileage for Depot " + i + ":");
            for (int j = 0; j < vehiclesPerDepot; j++) {
                mileage[index] = sc.nextInt();
                index++;
            }
        }

        // Merging all depot lists using Merge Sort
        mergeSort(mileage, 0, mileage.length - 1);

        // Display master maintenance schedule
        System.out.println("\nMaster Vehicle Maintenance Schedule (by Mileage):");
        for (int i = 0; i < mileage.length; i++) {
            System.out.print(mileage[i] + " ");
        }

        sc.close();
    }
}
