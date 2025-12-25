import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Menu for user choice
        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();

        // Checking user choice
        if (choice == 1) {
            System.out.println("Enter temperature in Fahrenheit:");
            double f = sc.nextDouble();
            double c = fahrenheitToCelsius(f);
            System.out.println("Temperature in Celsius: " + c);
        } 
        else if (choice == 2) {
            System.out.println("Enter temperature in Celsius:");
            double c = sc.nextDouble();
            double f = celsiusToFahrenheit(c);
            System.out.println("Temperature in Fahrenheit: " + f);
        } 
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
