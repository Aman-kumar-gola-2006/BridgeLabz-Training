import java.util.Scanner;

public class ParkingLotSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalSlots = 5;   // total parking capacity
        int occupied = 0;
        int choice;

        while (true) {
            System.out.println("\n------ Parking Lot Menu ------");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Exit System");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (occupied < totalSlots) {
                        occupied++;
                        System.out.println("Vehicle parked successfully.");
                    } else {
                        System.out.println("Parking Lot Full!");
                    }
                    break;

                case 2:
                    if (occupied > 0) {
                        occupied--;
                        System.out.println("Vehicle exited successfully.");
                    } else {
                        System.out.println("Parking lot is already empty.");
                    }
                    break;

                case 3:
                    System.out.println("Total Slots: " + totalSlots);
                    System.out.println("Occupied Slots: " + occupied);
                    System.out.println("Available Slots: " + (totalSlots - occupied));
                    break;

                case 4:
                    System.out.println("Exiting Parking System...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }

            if (occupied == totalSlots) {
                System.out.println("Parking is full. No more entries allowed.");
            }
        }
    }
}
