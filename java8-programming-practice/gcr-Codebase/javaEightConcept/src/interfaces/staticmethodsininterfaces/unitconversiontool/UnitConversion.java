package interfaces.staticmethodsininterfaces.unitconversiontool;

import java.util.Scanner;

public class UnitConversion {
	public static void main(String[] args) {

		// Used to take input from the user
		Scanner scanner = new Scanner(System.in);

		// Displaying the menu for unit conversion
		System.out.println("-------------Unit Conversion-------------");
		System.out.println("-------------1. KM to Miles--------------");
		System.out.println("-------------2. KG to Lbs----------------");

		// Asking user to choose the type of conversion
		System.out.println("Choose for Conversion : ");
		int choice = scanner.nextInt();

		// Switch is used to perform conversion based on user choice
		switch (choice) {

		// If user chooses KM to Miles conversion
		case 1 -> {
			System.out.println("Enter the Distance in Km");
			double distance = scanner.nextDouble();

			// Calling conversion method and printing result
			System.out.println("The distance in miles is : "
					+ Conversions.kmToMiles(distance));
		}

		// If user chooses KG to Lbs conversion
		case 2 -> {
			System.out.println("Enter the Weight in KG");
			double weight = scanner.nextDouble();

			// Calling conversion method and printing result
			System.out.println("The weight in lbs is : "
					+ Conversions.kgToLbs(weight));
		}

		// If user enters an invalid option
		default -> System.out.println("Invalid Choice");
		}
	}
}
