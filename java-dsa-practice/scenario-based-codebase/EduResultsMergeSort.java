import java.util.Scanner;

class EduResultsMergeSort {

    // Merge two sorted parts
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

        // Stable merge (higher marks first)
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

        System.out.print("Enter number of districts: ");
        int districts = sc.nextInt();

        System.out.print("Enter students per district: ");
        int studentsPerDistrict = sc.nextInt();

        int totalStudents = districts * studentsPerDistrict;
        int marks[] = new int[totalStudents];

        int index = 0;

        // Taking district-wise sorted marks
        for (int i = 1; i <= districts; i++) {
            System.out.println("Enter sorted marks for District " + i + ":");
            for (int j = 0; j < studentsPerDistrict; j++) {
                marks[index] = sc.nextInt();
                index++;
            }
        }

        // Merge all district lists
        mergeSort(marks, 0, marks.length - 1);

        // Display final rank list
        System.out.println("\nState-wise Rank List:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Rank " + (i + 1) + " : " + marks[i]);
        }

        sc.close();
    }
}
