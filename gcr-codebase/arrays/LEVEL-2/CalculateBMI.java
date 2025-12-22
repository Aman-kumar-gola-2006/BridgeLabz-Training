import java.util.*;
public class CalculateBMI{
	
	public static void main (String [] args){
	Scanner sc = new Scanner(System.in);
	
	// Input for number of persons 
	System.out.println("Enter number of persons" );
	int number = sc.nextInt();
	
	// created variable to store 
	double weight [] = new double[number]; 
	double height [] = new double[number];
	
	
	
	//Created for loop to take input of salaries and years of service
	for (int i=0; i<number; i++){
		System.out.println("Enter weight of " + (i+1) + " person" );
		double w = sc.nextDouble();
		
		
		System.out.println("Enter the height of " + (i+1) + " person" );
		double h = sc.nextDouble();
		
		// check for error inputs
		if (w <= 0 || h < 0) {
			System.out.println("Invalid input! Please enter again.");
			i--; // decrement index as required
		continue;
		}
			weight[i] = w;
			height[i] = h;
	}
	
	//created two new double variables to store BMI and Weight Status
	double Bmi [] = new double[number]; 
	double weightStatus [] = new double[number];
	
	
	// create for loop to calculate the BMI of each person
	for (int i=0; i<number; i++){
		Bmi[i]=  (weight[i]/(height[i]*height[i]));
	}
	
	//create for loop to calculate the Weight Status of each person
	for (int i=0; i<number; i++){
		if(Bmi[i]<=18.4){
			System.out.println("The " + (i+1)+ " person's weight is : " + weight[i] );
			System.out.println("The " + (i+1)+ "  person's height is : " + height[i] );
			System.out.println("The " + (i+1)+ "  person's Bmi is : " + Bmi[i] );
			System.out.println("The " + (i+1)+ "  person's weight status is Underweight " );
		}
		else if (Bmi[i] >= 18.5 && Bmi[i] <= 24.9){
			System.out.println("The " + (i+1)+ "  person's weight is : " + weight[i] );
			System.out.println("The " + (i+1)+ "  person's height is : " + height[i] );
			System.out.println("The " + (i+1)+ "  person's Bmi is : " + Bmi[i] );
			System.out.println("The " + (i+1)+ "  person's weight status is normal " );
		}
		else if (Bmi[i] >= 25.0 && Bmi[i] <= 39.9){
			System.out.println("The" + (i+1)+ "  person's weight is : " + weight[i] );
			System.out.println("The " + (i+1)+ "  person's height is : " + height[i] );
			System.out.println("The" + (i+1)+ "  person's Bmi is : " + Bmi[i] );
			System.out.println("The " + (i+1)+ "  person's weight status is Overweight " );
		}
		else if (Bmi[i] >= 40.0){
			System.out.println("The " + (i+1)+ "  person's weight is : " + weight[i] );
			System.out.println("The" + (i+1)+ "  person's height is : " + height[i] );
			System.out.println("The " + (i+1)+ " person's Bmi is : " + Bmi[i] );
			System.out.println("The " + (i+1)+ "  person's weight status is Obese " );
		}
		
		else {
			System.out.println("Invalid Input" );
		}
	}
	sc.close();
	}
}