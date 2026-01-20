import java.util.Scanner;

class ExamCellRankGenerator {

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
            if (leftArr[i] >= rightArr[j]) {   // higher score gets better rank
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

        System.out.print("Enter number of exam centers: ");
        int centers = sc.nextInt();

        System.out.print("Enter students per center: ");
        int studentsPerCenter = sc.nextInt();

        int totalStudents = centers * studentsPerCenter;
        int scores[] = new int[totalStudents];

        int index = 0;

        // Taking input center-wise
        for (int i = 1; i <= centers; i++) {
            System.out.println("Enter scores for Center " + i + ":");
            for (int j = 0; j < studentsPerCenter; j++) {
                scores[index] = sc.nextInt();
                index++;
            }
        }

        // Sorting all scores using Merge Sort
        mergeSort(scores, 0, scores.length - 1);

        // Display rank list
        System.out.println("\nState Level Rank List:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Rank " + (i + 1) + " : " + scores[i]);
        }

        sc.close();
    }
}
