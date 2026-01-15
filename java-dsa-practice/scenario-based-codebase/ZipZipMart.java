import java.util.*;

class Sale {
    int date;           // Format: YYYYMMDD
    double amount;

    public Sale(int date, double amount) {
        this.date = date;
        this.amount = amount;
    }
}

public class ZipZipMart {

    // Merge Sort
    public static void mergeSort(Sale[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merge process (stable)
    public static void merge(Sale[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Sale[] L = new Sale[n1];
        Sale[] R = new Sale[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            // Sort by date first
            if (L[i].date < R[j].date) {
                arr[k++] = L[i++];
            }
            // If dates equal → sort by amount
            else if (L[i].date == R[j].date && L[i].amount <= R[j].amount) {
                arr[k++] = L[i++];
            }
            else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sales records: ");
        int n = sc.nextInt();

        Sale[] sales = new Sale[n];

        // Take user input
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for record " + (i + 1));
            System.out.print("Date (YYYYMMDD): ");
            int date = sc.nextInt();
            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            sales[i] = new Sale(date, amount);
        }

        // Sort using Merge Sort
        mergeSort(sales, 0, n - 1);

        // Display sorted sales
        System.out.println("\nSorted Sales Summary (by Date, then Amount):");
        for (Sale s : sales) {
            System.out.println("Date: " + s.date + "  |  Amount: " + s.amount);
        }
    }
}
