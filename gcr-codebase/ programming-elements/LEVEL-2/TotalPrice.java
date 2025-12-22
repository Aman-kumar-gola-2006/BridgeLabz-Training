
import java.util.*;
public class TotalPrice {
	public static void calculateCost(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the unit price of the item");
		int price = sc.nextInt();
		System.out.println("Enter the quantity of the item");
		int quantity = sc.nextInt();
		
		int totalCost = price*quantity;
		
		System.out.println("The total purchase price is INR " + totalCost + " if the quantity "+ quantity + " and unit price is INR "+ price );
		
		
	
	}
	public static void main(String [] args){
		calculateCost();
	}
 }
