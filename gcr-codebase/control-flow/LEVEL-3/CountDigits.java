import java.util.*;
public class CountDigits {
	
	public static void countDigit(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count =0; 
		while(number>0){
			number = number/10;
			count++;
			
		}
		System.out.println("The digits are " + count);
		
	}
	
	public static void main (String [] args){
		countDigit();
		
	}
}