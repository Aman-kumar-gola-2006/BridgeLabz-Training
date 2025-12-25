import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Range of numbers
        int low = 1;
        int high = 100;

        System.out.println("Think of a number between 1 and 100.");

        while (true) {

            // Computer guesses the middle number
            int guess = (low + high) / 2;

            System.out.println("Is your number " + guess + "?");
            System.out.println("Enter feedback (high / low / correct):");
            String feedback = sc.next();

            // If guess is correct
            if (feedback.equals("correct")) {
                System.out.println("Computer guessed the number correctly!");
                break;
            }

            // If guess is too high
            else if (feedback.equals("high")) {
                high = guess - 1;
            }

            // If guess is too low
            else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }

        sc.close();
    }
}
