import java.util.Scanner;

class FitnessTrackerBubbleSort {

    // Bubble Sort logic
    static void bubbleSort(int arr[], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                // Swap if current user has fewer steps than next user
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

        System.out.print("Enter number of users (max 20): ");
        int n = sc.nextInt();

        int steps[] = new int[n];

        System.out.println("Enter step count for each user:");
        for (int i = 0; i < n; i++) {
            steps[i] = sc.nextInt();
        }

        // Sorting step counts using Bubble Sort
        bubbleSort(steps, n);

        // Display leaderboard
        System.out.println("\nDaily Step Leaderboard:");
        for (int i = 0; i < n; i++) {
            System.out.println("Rank " + (i + 1) + " : " + steps[i] + " steps");
        }

        sc.close();
    }
}
