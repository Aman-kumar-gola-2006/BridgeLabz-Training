import java.util.*;
public class LeapYear {
	
	public static void checkLeapYear(){
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		if (year>=1582 && (year % 4 ==0 && year%400==0)) {
				System.out.println( year + " is a Leap Year");
		}
			
		else {
				System.out.println(year+ " is not a Leap Year");
			}
		
		
	}
	
	public static void main (String [] args){
		checkLeapYear();
		
	}
}