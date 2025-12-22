import java.util.*;
public class Armstrong {
	public static int cube(int num){
		return num*num*num;
	}
	
	public static void checkArmstrong(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int sum=0;
		int originalNumber=number;
		
		while(originalNumber!=0){
			int digit = originalNumber%10;
			sum= sum+ cube(digit);
			
			originalNumber= originalNumber/10;
			
		}
		if (sum==number){
			System.out.println(number + " Is a Armstrong Number");
		}
		else {
			System.out.println(number + " Is not a Armstrong Number");
		}
		
	}
	
	public static void main (String [] args){
		checkArmstrong();
		
	}
}