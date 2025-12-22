import java.util.*;
public class MultiplesOfNumber{
	
	public static void findMultiples(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count = number-1;
		if(number<100){
			while(count>=1){
				
					if(number%count ==0){
						System.out.println(count+ " ");
					}
					count--;
			
		}
		}
		
	}
	
	public static void main (String [] args){
		findMultiples();
		
	}
}