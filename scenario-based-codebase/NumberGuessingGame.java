// // /The Number Guessing Game
// // A game asks the player to guess a number between 1 and 100.
// // Core Java Scenario Based Problem Statements
// Give hints like "Too high" or "Too low
// Count attempts and exit after 5 wrong tries.


import java.util.*;
import java.util.Random;


public class NumberGuessingGame {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		int secretNumber = random.nextInt(100) + 1; // 1 to 100
		int guess;
		int attempts = 0;
		int maxAttempts = 5;

		System.out.println("Welcome to the Number Guessing Game !");
		System.out.println("Guess a number between 1 and 100");
		System.out.println("You have only 5 attemps.\n");

		do{
			System.out.println("Enter your guess: ");
			guess = sc.nextInt();
			attempts++;

			if(guess > secretNumber){
				System.out.println("Too high!");
			}
			else if(guess < secretNumber){
				System.out.println("Too Low!");
			}else{
				System.out.println("Congratulations! you guess it right.");
				System.out.println("You guesses in " + attempts + "attempts.");
				break;
			}
			 System.out.println("Attempts left: " + (maxAttempts - attempts));
            System.out.println("----------------------------------");

        } while (attempts < maxAttempts);

        if (attempts == maxAttempts && guess != secretNumber) {
            System.out.println("❌ Game Over!");
            System.out.println("The correct number was: " + secretNumber);
        }

        sc.close();
    }
}

	
