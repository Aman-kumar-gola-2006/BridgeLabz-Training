import java.util.*;
public class UnitConvertorSecond  {
	
	//creating a method to convert Yards to feets
	public static double convertYardsToFeet(double yards){
	  	double feets =yards * 3;
        return feets;
	}
		//creating a method to convert feets to Yards
	public static double convertFeetToYards(double feets){
	  	double yards = feets * 0.33333;
        return yards;
	}
	
		//creating a method to convert Meter to inches
	public static double convertMetersToInches(double meter){
	  	double feets =meter *  0.0254;
        return feets;
	}
	
		//creating a method to convert inches to centimeter
	public static double convertInchesToCentimeters(double inches){
	  	double centimeter = inches * 2.54;
        return centimeter;
	}
	
	
	
	public static void main (String [] args){
	
	//taking scanner object
		Scanner sc = new Scanner(System.in);
		//taking the user input for the km
		System.out.println("Enter the yards");
		int yards = sc.nextInt();
		System.out.println("Enter the feets");
		int feets = sc.nextInt();
		System.out.println("Enter the meters");
		int meter = sc.nextInt();
		System.out.println("Enter the inches");
		int inches = sc.nextInt();
		System.out.println(yards + " km = " + convertYardsToFeet(yards)+ " feets");
	    System.out.println(feets + " miles = " + convertFeetToYards(feets) + " yards");
		System.out.println(meter + " meter = " + convertMetersToInches(meter) + "inches");
		System.out.println(inches + " feets = " + convertInchesToCentimeters(inches) + " centimeter");

		
		
		
	}
}