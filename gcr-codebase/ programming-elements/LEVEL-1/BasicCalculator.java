import java.util.*;

public class BasicCalculator {

		public static int addition (int a, int b){
			int addition = a+b;
			return addition;
		}
		public static int subtraction(int a, int b){
			int sub = a-b;
			return sub;
		}
		public static int multiplication(int a, int b){
			int multi = a*b;
			return multi;
		}
		public static int division(int a, int b){
			int div = a/b;
			return div;
		}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
		System.out.println("Enter the first number");
		int number1 = sc.nextInt();
		System.out.println("Enter the second number");
		int number2 = sc.nextInt();
		
		System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + number1 +" and " +number2 +" is " + addition(number1, number2)+ "," + subtraction(number1, number2)+ " " + multiplication(number1, number2) + " and " + division(number1, number2)); 

	}
}