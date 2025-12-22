import java.util.*;
public class LeapYear {
	
	//creating a boolean method to check the leap year
	public static boolean checkLeapYear(){
		
	//taking scanner object
		Scanner sc = new Scanner(System.in);
		//taking the user input for the year
		System.out.println("Enter the year");
		int year = sc.nextInt();
		
		//checking the year 
		if (year>=1582 && (year % 4 ==0 && year%400==0)) {
				return true;
		}
			return false;
	}
	
	public static void main (String [] args){
		//display the result as true or false 
		System.out.println(checkLeapYear());
		
	}
}