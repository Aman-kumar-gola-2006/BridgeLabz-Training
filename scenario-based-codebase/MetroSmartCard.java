import java.util.Scanner;

public class MetroSmartCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 200; // Initial smart card balance
        double distance;
        double fare;

        System.out.println("===== Delhi Metro Smart Card System =====");
        System.out.println("Initial Balance: ₹" + balance);

        while (true) {

            System.out.print("\nEnter distance in km (Enter -1 to exit): ");
            distance = sc.nextDouble();

            // Exit condition
            if (distance == -1) {
                System.out.println("Thank you for using Delhi Metro.");
                break;
            }

            // Fare calculation using ternary operator
            fare = (distance <= 5) ? 20 :
                   (distance <= 10) ? 30 :
                   (distance <= 20) ? 40 : 50;

            // Check balance
            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare Deducted: ₹" + fare);
                System.out.println("Remaining Balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance!");
                System.out.println("Please recharge your smart card.");
                break;
            }
        }

        sc.close();
    }
}
