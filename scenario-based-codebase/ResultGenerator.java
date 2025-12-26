import java.util.Scanner;

public class ResultGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        double average;
        int marks;

        System.out.println("===== Raj's Result Generator =====");

        // Input marks using for loop
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            marks = sc.nextInt();
            total += marks;
        }

        // Calculate average
        average = total / 5.0;

        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average Marks: " + average);

        // Grade calculation using switch
        switch ((int) average / 10) {
            case 10:
            case 9:
                System.out.println("Grade: A");
                break;
            case 8:
                System.out.println("Grade: B");
                break;
            case 7:
                System.out.println("Grade: C");
                break;
            case 6:
                System.out.println("Grade: D");
                break;
            default:
                System.out.println("Grade: Fail");
        }

        sc.close();
    }
}
