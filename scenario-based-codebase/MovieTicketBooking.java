import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;
        double totalAmount;
        char moreCustomer;

        System.out.println("🎬 Welcome to Movie Ticket Booking App 🎬");

        do {

            totalAmount = 0;

            System.out.println("\nSelect Movie Type:");
            System.out.println("1. Action");
            System.out.println("2. Comedy");
            System.out.println("3. Horror");
            System.out.print("Enter choice: ");
            int movieType = sc.nextInt();

            switch (movieType) {
                case 1:
                    totalAmount += 200;
                    break;
                case 2:
                    totalAmount += 180;
                    break;
                case 3:
                    totalAmount += 220;
                    break;
                default:
                    System.out.println("Invalid movie type!");
            }

            System.out.println("\nSelect Seat Type:");
            System.out.println("1. Silver");
            System.out.println("2. Gold");
            System.out.print("Enter choice: ");
            int seatType = sc.nextInt();

            if (seatType == 1) {
                totalAmount += 100;
            } else if (seatType == 2) {
                totalAmount += 150;
            } else {
                System.out.println("Invalid seat type!");
            }

            System.out.println("\nDo you want snacks?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter choice: ");
            int snacks = sc.nextInt();

            if (snacks == 1) {
                totalAmount += 80;
            }

            System.out.println("\n🎟 Ticket Summary");
            System.out.println("Total Amount: ₹" + totalAmount);

            System.out.print("\nBook ticket for another customer? (y/n): ");
            moreCustomer = sc.next().charAt(0);

        } while (moreCustomer == 'y' || moreCustomer == 'Y');

        System.out.println("\nThank you for using Movie Ticket Booking App!");
        sc.close();
    }
}
