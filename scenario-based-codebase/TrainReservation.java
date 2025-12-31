import java.util.Scanner;

public class TrainReservation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalSeats = 10;
        int seatNumber = 1;
        double baseFare = 500;
        int choice;

        System.out.println("------ Train Reservation System ------");

        while (true) {

            System.out.println("\n1. Book Ticket");
            System.out.println("2. Check Available Seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (totalSeats == 0) {
                        System.out.println("No seats available!");
                        break;
                    }

                    System.out.print("Enter number of tickets to book: ");
                    int tickets = sc.nextInt();

                    if (tickets > totalSeats) {
                        System.out.println("Only " + totalSeats + " seats available!");
                        break;
                    }

                    for (int i = 1; i <= tickets; i++) {

                        sc.nextLine(); // clear buffer
                        System.out.print("\nEnter Passenger Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();

                        double fare;
                        if (age < 10) {
                            fare = baseFare * 0.5;
                        } else {
                            fare = baseFare;
                        }

                        System.out.println("\n--- Ticket Details ---");
                        System.out.println("Name    : " + name);
                        System.out.println("Age     : " + age);
                        System.out.println("Seat No : " + seatNumber);
                        System.out.println("Fare    : ₹" + fare);

                        seatNumber++;
                        totalSeats--;
                    }

                    System.out.println("\nBooking Successful!");
                    System.out.println("Remaining Seats: " + totalSeats);
                    break;

                case 2:
                    System.out.println("Available Seats: " + totalSeats);
                    break;

                case 3:
                    System.out.println("Thank you for using Train Reservation System.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

            if (totalSeats == 0 || choice == 3) {
                System.out.println("Booking Closed.");
                break;
            }
        }

        sc.close();
    }
}
