import java.util.*;
public class NaturalNumber{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number : ");
		int number = sc.nextInt();

 
		if(number > 0 ){
				int Sum_of_naturalNumber = number * (number +1) / 2;

				System.out.println("The sum of : " + number + "  sum of natural number is " + Sum_of_naturalNumber);

		}else{System.out.println("The number : " +number+ " is not natural number");

		}
		sc.close();

	}
}