import java.util.*;

public class UnitConvertorThirdExtra {

    // method to convert Fahrenheit to Celsius
    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }

    // method to convert Celsius to Fahrenheit
    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }

    // method to convert Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = pounds * 0.453592;
        return pounds2kilograms;
    }

    // method to convert Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = kilograms * 2.20462;
        return kilograms2pounds;
    }

    // method to convert Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = gallons * 3.78541;
        return gallons2liters;
    }

    // method to convert Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = liters * 0.264172;
        return liters2gallons;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to Java World");

        System.out.println("Enter Fahrenheit");
        double f = sc.nextDouble();

        System.out.println("Enter Celsius");
        double c = sc.nextDouble();

        System.out.println("Enter Pounds");
        double p = sc.nextDouble();

        System.out.println("Enter Kilograms");
        double k = sc.nextDouble();

        System.out.println("Enter Gallons");
        double g = sc.nextDouble();

        System.out.println("Enter Liters");
        double l = sc.nextDouble();

        System.out.println("Fahrenheit to Celsius = " + convertFarhenheitToCelsius(f));
        System.out.println("Celsius to Fahrenheit = " + convertCelsiusToFarhenheit(c));
        System.out.println("Pounds to Kilograms = " + convertPoundsToKilograms(p));
        System.out.println("Kilograms to Pounds = " + convertKilogramsToPounds(k));
        System.out.println("Gallons to Liters = " + convertGallonsToLiters(g));
        System.out.println("Liters to Gallons = " + convertLitersToGallons(l));

        sc.close();
    }
}