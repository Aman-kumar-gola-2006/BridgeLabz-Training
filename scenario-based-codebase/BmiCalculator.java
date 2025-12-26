// Problem 2: Maya’s BMI Fitness Tracker

// Maya is a fitness coach who wants to calculate BMI for her clients.

// Write a Java program that takes height and weight as input, calculates BMI using the formula BMI = weight / (height * height), and prints the BMI category as Underweight, Normal, or Overweight using if-else conditions. Use meaningful variable names and proper comments to maintain clean code.

import java.util.Scanner;

public class BmiCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();

        System.out.print("Enter height in meters: ");
        double height = sc.nextDouble();

        // BMI calculation
        double bmi = weight / (height * height);

        System.out.println("\nYour BMI is: " + bmi);

        // BMI Category
        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI Category: Normal");
        } else {
            System.out.println("BMI Category: Overweight");
        }

        sc.close();
    }
}
