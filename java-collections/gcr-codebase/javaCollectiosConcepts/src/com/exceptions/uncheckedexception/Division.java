package com.exceptions.uncheckedexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter the value of a : ");
			int a=scanner.nextInt();
			
			System.out.println("Enter the value of b : ");
			int b=scanner.nextInt();
			
			
			int result =a/b;
			System.out.println("Result : "+ result);
		} catch (ArithmeticException e) {
			
				System.out.println("Cannot divide by Zero");
		}
		catch (InputMismatchException e) {
			System.out.println("Please enter Numeric value only");
		}

	}

}
