import java.util.*;
public class FizzBuzzByWhileLoop{
	
	public static void  checkMultiples(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		while (number>0){
			 if(number%3 ==0 && number%5 ==0 ){
				System.out.println("Fizzbuzz");
			}
			else if(number%5 ==0){
				System.out.println("Buzz");
			}
			else if(number%3 ==0){
				System.out.println("Fizz");
			}
		}
		else {
			System.out.println("Not a multiple of 3 & 5");
		}
	}
	
	public static void main (String [] args){
		checkMultiples();
		
	}
}