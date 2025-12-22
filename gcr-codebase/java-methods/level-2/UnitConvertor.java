import java.util.*;
public class UnitConvertor  {
	
	//creating a method to convert Km ToMiles
	public static double convertKmToMiles(double km){
	  	double miles =km* 0.621371;
        return miles;
	}
		//creating a method to convert Miles to km
	public static double convertMilesTokm(double miles){
	  	double km =1.60934 * miles;
        return km;
	}
	
		//creating a method to convert Meter to feets
	public static double convertMetersToFeet(double meter){
	  	double feets =meter *  3.28084;
        return feets;
	}
	
		//creating a method to convert feets to meter
	public static double convertFeetToMiles(double feets){
	  	double meters = feets * 0.3048;
        return meters;
	}
	
	
	
	public static void main (String [] args){
	
	//taking scanner object
		Scanner sc = new Scanner(System.in);
		//taking the user input for the km
		System.out.println("Enter the kilometers");
		int km = sc.nextInt();
		System.out.println("Enter the miles");
		int miles = sc.nextInt();
		System.out.println("Enter the meters");
		int meter = sc.nextInt();
		System.out.println("Enter the feets");
		int feets = sc.nextInt();
		System.out.println(km + " km = " + convertKmToMiles(km)+ " miles");
	    System.out.println(miles + " miles = " + convertMilesTokm(miles) + " kilometers");
		System.out.println(meter + " meter = " + convertMetersToFeet(meter) + "feets");
		System.out.println(feets + " feets = " + convertFeetToMiles(feets) + " miles");

		
		
		
	}
}