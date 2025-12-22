import java.util.*;
public class PositiveCheck{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = sc.nextInt();

		if(number > 0){
			System.out.println("Number is positive" + "Print" + number);
		}else if (number == 0 ){
			System.out.println("Number is zero print " +number);
		}else{
			System.out.println("Number is negative" + number);
		}
		sc.close();
	}
	
}


