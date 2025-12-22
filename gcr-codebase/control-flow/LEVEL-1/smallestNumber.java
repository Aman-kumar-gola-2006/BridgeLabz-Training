import java.util.*;
public class smallestNumber{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
		System.out.println("Enter number 1 : ");
		int number1 = sc.nextInt();

		System.out.println("Enter number 2 : ");
		int number2 = sc.nextInt();

		System.out.println("Enter number 3 : ");
		int number3 = sc.nextInt();

		if (number1 < number2 && number1<number3){
			System.out.println (" Is first number the smallest ? yes ") ;
			}else{
			System.out.println (" Is first number the smallest ? no ") ;

			}
			sc.close();

		}

	}
