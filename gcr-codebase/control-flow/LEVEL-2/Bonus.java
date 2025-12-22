import java.util.*;
public class Bonus{
	
	public static void calculateBonus(){
		Scanner sc = new Scanner(System.in);
		int salary = sc.nextInt();
		int currentYear = 2025;
		int serviceYear= sc.nextInt();
		int bonusAmount= 0;
		
		if ((currentYear-serviceYear)>5){
			bonusAmount= (salary*5)/100;
		}
		
		System.out.println("The bonus amount is " + bonusAmount);

		
	}
	
	public static void main (String [] args){
		calculateBonus();
		
	}
}