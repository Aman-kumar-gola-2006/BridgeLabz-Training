import java.util.Scanner;

public class FitnessTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] pushups = new int[7];
        int total = 0;
        int count = 0;

        System.out.println("Enter push-ups for 7 days (Enter 0 for rest day):");

        // Taking input
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            pushups[i] = sc.nextInt();
        }

        // Using for-each loop
        for (int p : pushups) {

            if (p == 0) {
                continue;   // skip rest day
            }

            total = total + p;
            count++;
        }

        double average = total / (double) count;

        System.out.println("\n--- Fitness Report ---");
        System.out.println("Total Push-ups: " + total);
        System.out.println("Average Push-ups: " + average);

        sc.close();
    }
}
