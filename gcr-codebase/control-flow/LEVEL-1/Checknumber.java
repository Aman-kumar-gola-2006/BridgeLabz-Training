import java.util.*;

public class Checknumber{
	public static void main (String[] args ){
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");

		System.out.println("Enter the number : ");
		int number = sc.nextInt();

		if(number % 5 == 0){
			System.out.println("Is the number " + number + "divisible by 5 ? yes " );
		}
			else{
			System.out.println("Is the number " + number + "divisible by 5 ? no " );
			}
			sc.close();

			}
		}
	