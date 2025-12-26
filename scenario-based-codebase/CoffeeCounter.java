/*
 Problem 1: The Coffee Counter Chronicles

 This program takes coffee orders from users,
 calculates total bill with GST,
 and continues until the user types 'exit'.
*/

import java.util.Scanner;

public class CoffeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String coffeeType;
        double price = 0;
        int quantity;
        double totalAmount, gst, finalBill;

        System.out.println("===== Welcome to Ravi's Coffee Cafe =====");

        while (true) {
            System.out.print("\nEnter coffee type (Espresso / Latte / Cappuccino) or type 'exit': ");
            coffeeType = sc.nextLine().toLowerCase();

            if (coffeeType.equals("exit")) {
                System.out.println("Thank you for visiting!");
                break;
            }

            switch (coffeeType) {
                case "espresso":
                    price = 120;
                    break;
                case "latte":
                    price = 150;
                    break;
                case "cappuccino":
                    price = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type.");
                    continue;
            }

            System.out.print("Enter quantity: ");
            quantity = sc.nextInt();
            sc.nextLine(); // clear buffer

            totalAmount = price * quantity;
            gst = totalAmount * 0.05;
            finalBill = totalAmount + gst;

            System.out.println("Total Bill: ₹" + finalBill);
        }

        sc.close();
    }
}
