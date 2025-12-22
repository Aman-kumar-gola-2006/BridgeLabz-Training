import java.util.*;
public class CheckNumber{
	public static void main(String [] args ){
		int[] number = new int[5];
		Scanner sc = new Scanner(System.in);


		//taking input 5 number

		System.out.println("Enter 5 number");
		for(int i=0; i<number.length; i++){
			number[i] = sc.nextInt();
		}

		// checking number positive and even or  odd according to number

		for(int i=0; i<number.length; i++){
			if(number[i] >0 ){
				System.out.println (number[i] + "is positive and ");
				if(number[i] % 2 == 0){
					System.out.println("Even");
				}else {
					System.out.println("odd");
				}
			}
			else if(number[i] < 0){
				System.out.println(number[i] + "is negative ");
			}else{
				System.out,println(number[i] + " is zerp ");
			}

		}

		//comparing fit and last element


		if(number[0] == number[number.length -1]){
			System.out.println("First and last element are equal");
		}
		else if(number[0] > number[number.length-1]){
			System.out.println("First element is greater than last element");
		}else{
			System.out.println("first element is less than last element");
		}
		sc.close();

	}
	
}