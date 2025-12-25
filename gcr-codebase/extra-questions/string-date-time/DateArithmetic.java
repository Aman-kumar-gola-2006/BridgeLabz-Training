//Create a program that:
//  Takes a date input and adds 7 days, 1 month, and 2 years to it.
//  Then subtracts 3 weeks from the result.
// Hint: Use LocalDate.plusDays(), plusMonths(), plusYears(), and
// minusWeeks() methods.

import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take date input from user
        System.out.print("Enter a date (yyyy-mm-dd): ");
        String inputDate = sc.next();

        // Convert input to LocalDate
        LocalDate date = LocalDate.parse(inputDate);

        // Add 7 days, 1 month, and 2 years
        LocalDate updatedDate = date.plusDays(7)
                                    .plusMonths(1)
                                    .plusYears(2);

        // Subtract 3 weeks
        updatedDate = updatedDate.minusWeeks(3);

        // Display results
        System.out.println("Original Date : " + date);
        System.out.println("Final Date    : " + updatedDate);

        sc.close();
    }
}
