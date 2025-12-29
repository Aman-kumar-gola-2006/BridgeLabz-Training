import java.util.Scanner;

public class ShopkeeperDiscount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Constant values
        final int ITEMS = 5;
        final double DISCOUNT_20 = 0.20;
        final double DISCOUNT_10 = 0.10;

        double totalAmount = 0;
        double discount = 0;
        double finalAmount;

        // Taking item prices
        System.out.println("Enter prices of " + ITEMS + " items:");

        for (int i = 1; i <= ITEMS; i++) {
            System.out.print("Enter price of item " + i + ": ");
            double price = sc.nextDouble();
            totalAmount += price;
        }

        // Discount logic
        if (totalAmount >= 5000) {
            discount = totalAmount * DISCOUNT_20;
        } 
        else if (totalAmount >= 3000) {
            discount = totalAmount * DISCOUNT_10;
        } 
        else {
            discount = 0;
        }

        finalAmount = totalAmount - discount;

        // Display result
        System.out.println("\n----- BILL SUMMARY -----");
        System.out.println("Total Amount: ₹" + totalAmount);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Payable Amount: ₹" + finalAmount);

        sc.close();
    }
}
