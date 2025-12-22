import java.util.*;
public class Abundant {
	
	public static void checkAbundant(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int sum =0;
		for(int i=1; i<number; i++){
			if(number%i ==0 ){
				sum+=i;
			}
		}
		if(sum>number){
			System.out.println(number +" is an Abundant Number ");
		}
		else {
			System.out.println(number +" is not an Abundant Number ");
		}	
	}
	public static void main (String [] args){
		checkAbundant();
	}
}