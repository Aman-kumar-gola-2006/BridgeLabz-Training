// Write a program that:
//  Takes two date inputs and compares them to check if the first date is before, after,
// or the same as the second date.
// Hint: Use isBefore(), isAfter(), and isEqual() methods from the LocalDate class.

import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take first date input
        System.out.print("Enter first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(sc.next());

        // Take second date input
        System.out.print("Enter second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(sc.next());

        // Compare dates
        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE the second date.");
        } 
        else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER the second date.");
        } 
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the SAME.");
        }

        sc.close();
    }
}
