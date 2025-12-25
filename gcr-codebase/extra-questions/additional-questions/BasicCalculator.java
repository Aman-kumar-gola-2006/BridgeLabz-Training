import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking two numbers
        System.out.println("Enter first number:");
        double a = sc.nextDouble();

        System.out.println("Enter second number:");
        double b = sc.nextDouble();

        // Menu for operations
        System.out.println("Choose operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = sc.nextInt();

        // Performing selected operation
        if (choice == 1) {
            System.out.println("Result: " + add(a, b));
        }
        else if (choice == 2) {
            System.out.println("Result: " + subtract(a, b));
        }
        else if (choice == 3) {
            System.out.println("Result: " + multiply(a, b));
        }
        else if (choice == 4) {
            System.out.println("Result: " + divide(a, b));
        }
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }

    // Function for addition
    public static double add(double x, double y) {
        return x + y;
    }

    // Function for subtraction
    public static double subtract(double x, double y) {
        return x - y;
    }

    // Function for multiplication
    public static double multiply(double x, double y) {
        return x * y;
    }

    // Function for division
    public static double divide(double x, double y) {

        if (y == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return x / y;
    }
}
