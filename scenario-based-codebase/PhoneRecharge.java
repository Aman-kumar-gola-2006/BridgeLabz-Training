import java.util.Scanner;

public class PhoneRecharge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 0;
        int choice;

        do {
            System.out.println("\n----- Phone Recharge Menu -----");
            System.out.println("1. Jio");
            System.out.println("2. Airtel");
            System.out.println("3. VI");
            System.out.println("4. Exit");
            System.out.print("Select Operator: ");
            choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using Recharge Service!");
                break;
            }

            System.out.print("Enter recharge amount: ");
            double amount = sc.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Jio Recharge Successful!");
                    System.out.println("Offer: 1.5GB/day for 28 days");
                    balance += amount;
                    break;

                case 2:
                    System.out.println("Airtel Recharge Successful!");
                    System.out.println("Offer: Unlimited Calls + 2GB/day");
                    balance += amount;
                    break;

                case 3:
                    System.out.println("VI Recharge Successful!");
                    System.out.println("Offer: Weekend Data Rollover");
                    balance += amount;
                    break;

                default:
                    System.out.println("Invalid Operator Choice");
            }

            System.out.println("Current Balance: ₹" + balance);

        } while (true);

        sc.close();
    }
}
