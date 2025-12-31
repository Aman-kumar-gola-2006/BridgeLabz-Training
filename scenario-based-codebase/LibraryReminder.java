import java.util.Scanner;

public class LibraryReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dueDate, returnDate;
        int finePerDay = 5;
        int fine;

        System.out.println("📚 Library Fine Calculator");

        // Loop for 5 books
        for (int i = 1; i <= 5; i++) {

            System.out.println("\nBook " + i);

            System.out.print("Enter Due Date (in days): ");
            dueDate = sc.nextInt();

            System.out.print("Enter Return Date (in days): ");
            returnDate = sc.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                fine = lateDays * finePerDay;
                System.out.println("Late by " + lateDays + " days");
                System.out.println("Fine: ₹" + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }

        sc.close();
    }
}
