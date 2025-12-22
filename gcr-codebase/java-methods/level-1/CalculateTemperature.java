// created a program CalculateTemperature that takes temperature and windspeed from the 
// command line and Print the WindChill  .


import java.util.Scanner;
import java.lang.Math;
public class CalculateTemperature{
	public static double calculateWindChill(double temperature, double windSpeed ){
	
		double windChill = 35.74 + (0.6215*temperature ) + (0.4275*temperature - 35.75)* Math.pow(windSpeed, 0.16);
	
		// return the result
		return windChill;
	}
	
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
	  
		//take input of temperature and windSpeed from user
		System.out.println("enter the temperature ");
		double temperature = sc.nextDouble();
		System.out.println("enter the windSpeed ");
		double windSpeed = sc.nextDouble();
		
		//creating object of CalculateTemperature class to use the function.
		CalculateTemperature ct = new CalculateTemperature();
		
		// Print the WindChill calculated by the method calculateWindChill
		// calling the calculateWindChill() method here
		double answer = ct.calculateWindChill(temperature, windSpeed);
		
		System.out.println("The calculated WindChill is   : "+ answer);
		
	}
}