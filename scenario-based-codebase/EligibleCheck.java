// 3. Election Booth Manager ️
// Design a polling booth system.
// ● Take age input.
// ● Use if to check if eligible (>=18).
// ● Record vote (1, 2, or 3 for candidates).
// ● Loop for multiple voters, exit on special code.





import java.util.Scanner;

public class EligibleCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int age;
        int vote;

        System.out.println("===== Election Booth System =====");

        while (true) {

            System.out.print("\nEnter age (Enter -1 to exit): ");
            age = sc.nextInt();

            // Exit condition
            if (age == -1) {
                System.out.println("Election process ended.");
                break;
            }

            // Age check
            if (age >= 18) {
                System.out.println("You are eligible to vote.");

                System.out.println("Choose your candidate:");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");

                System.out.print("Enter your vote (1/2/3): ");
                vote = sc.nextInt();

                switch (vote) {
                    case 1:
                        System.out.println("You voted for Candidate A.");
                        break;
                    case 2:
                        System.out.println("You voted for Candidate B.");
                        break;
                    case 3:
                        System.out.println("You voted for Candidate C.");
                        break;
                    default:
                        System.out.println("Invalid vote. Please choose 1, 2, or 3.");
                }

            } else {
                System.out.println("You are not eligible to vote (Age must be 18 or above).");
            }
        }

        sc.close();
    }
}
