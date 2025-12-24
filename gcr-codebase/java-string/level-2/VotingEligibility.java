import java.util.*;

// Program to check voting eligibility of students
public class VotingEligibility {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {

        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            // Generate age between 10 and 99
            ages[i] = (int)(Math.random() * 90) + 10;
        }
        return ages;
    }

    // Method to check voting eligibility
    
    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Method to display result in tabular format
    public static void displayResult(String[][] result) {

        System.out.println("Student\tAge\tCan Vote");
        System.out.println("---------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                result[i][0] + "\t" +
                result[i][1]
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int n = sc.nextInt();

        int[] ages = generateAges(n);
        String[][] eligibility = checkVotingEligibility(ages);

        displayResult(eligibility);

        sc.close();
    }
}