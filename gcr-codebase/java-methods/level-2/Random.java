// created a program Random that generates five 4 digit random values 
// and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().

import java.util.Scanner;
import java.lang.Math;
public class Random{
	
	// Method to generate the 4 digit random numbers in array
	public int[] generate4DigitRandomArray(int size){
		
		// Integer array to store the random numbers
		int randomArray[] = new int [size];
		
		// For loop to find and store the random numbers in the array
		for(int i=0; i<size; i++){
			randomArray[i]= (int) (Math.random()*(9999- 1000+1)+1000);
		}
		
		// return the result
		return randomArray;
	}
	
	// Method to calculate the Average, minimum and maximum numbers in the array
	public double[] findAverageMinMax(int[] numbers, int size){
		
		// array to store the Average, minimum and maximum numbers 
		double result [] = new double[3];
		
		// variable to store the sum of all the random numbers, which will help in finding the average.
		double sum =0; 
		
		// for loop to calculate sum of all the random numbers
		for (int i=0; i<size; i++){
			sum+= numbers[i];
		}
		
		// Average of the random numbers 
		double average = sum/size;
		
		// Find Minimum and Maximum value in the array
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		for (int i=0; i<size; i++){
			if (numbers[i] >max ){
				max = numbers[i];
			}
		}
		
		for (int i=0; i<size; i++){
			if (numbers[i]<min ){
				min = numbers[i];
			}
		}
		
		// store the values in the array
		result [0] = average;
		result[1]= max;
		result[2]= min;
		
		// return the resulted array
		return result;
		
		
	}

	
	public static void main(String [] args){
		
		// Created a Scanner Object
		Scanner sc = new Scanner(System.in);
	  
		//take input of size of the Array
		System.out.println("enter the size of Array ");
		int size = sc.nextInt();
		
		
		//creating object of CalculateTemperature class to use the function.
		Random rn = new Random();
		
		// Print the WindChill calculated by the method calculateWindChill
		// calling the calculateWindChill() method here
		int answer [] = rn.generate4DigitRandomArray(size);
		
		// Print the generated random numbers 
		System.out.print("The Random Numbers Are : ");
		for(int i=0; i<size; i++){
			System.out.print(answer[i] +" ");
		}
		
		// array to store the findAverageMinMax() method result
		double operations [] = rn.findAverageMinMax(answer, size);
		
		// Print the required values 
		System.out.println("\nThe Average of the Random Numbers Are : " + operations[0]);
		System.out.println("The Maximum Number among the Random Numbers Are : " + operations[1]);
		System.out.println("The Minimum Number among the Random Numbers Are : " + operations[2]);
		
		
		
		
	}
}