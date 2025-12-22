import java.util.*;
public class Factors {
	
	public static void findFactors   (){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if(number>0){
			for(int i=1; i<=number; i++){
				if(number%i==0){
					System.out.println(i + " " );
				}
			}
		}
	}
	
	public static void main (String [] args){
		findFactors();
		
	}
}