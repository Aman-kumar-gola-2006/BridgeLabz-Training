import java.util.*;
public class largestNumber{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");

		System.out.println("Enter the number1 : ");
		int Number1 = sc.nextInt();

		System.out.println("Enter the number2 : ");
		int Number2 = sc.nextInt();

		System.out.println("Enter the number3 : ");
		int Number3 = sc.nextInt();

		if(Number1 > Number2 && Number1 >Number3){
			System.out.println("is the first number the largest ? yes");

			}else if (Number2 > Number1 && Number2 >Number3){
				System.out.println("is the second number the largest ? yes");
			}else {
			System.out.println("is the third number the largest ? yes");

		}
		sc.close();
	}
}