import java.util.*;
public class FactorsByWhileLoop {
	
	public static void findFactors   (){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if(number>0){
			int count =1;
			while(count<=number){
				if(number%count==0){
					System.out.println(count + " " );
				}
				count++;
			}
			
		}
	}
	
	public static void main (String [] args){
		findFactors();
		
	}
}