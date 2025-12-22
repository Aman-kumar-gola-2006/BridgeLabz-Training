// created a program TrignometricOperations that takes angle in degrees from the 
// command line and Print the different .


import java.util.Scanner;
import java.lang.Math;
public class TrignometricOperations {
	public static double[] calculateTrigonometricFunctions(double angle ){
	
		double radians = Math.toRadians(angle);
		
		
		// created an integer array to store remaining chocolates and chocolates each children got
		double result [] = new double [3];
		
		// integer variables to store remaining and each children got chocolate
		double sineValue  = Math.sin(radians);
		double coSineValue  = Math.cos(radians);
		double tangentValue  = Math.tan(radians);
		

		// store the values into the array 
		result[0]= sineValue;
		result[1]= coSineValue;
		result[2]= tangentValue;
		
		// return the resulted array
		return result;
	}
	
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
		//take input of chocolates from user
		System.out.println("enter the angle in degrees ");
		double angle = sc.nextDouble();
		
		//creating object of SpringSeason class to use the function.
		TrignometricOperations t = new TrignometricOperations();
		
		// Print the remainder and each chocolate children got by
		// calling the TrignometricOperations() method here
		double answer [] = t.calculateTrigonometricFunctions(angle);
		
		System.out.println("The sin value is  : "+ answer[0]);
		System.out.println("The cos value is  : "+ answer[1]);
		System.out.println("The tan value is  : "+ answer[2]);
	}
}