import java.util.*;
public class UniversityDiscount{
	public static void main(String[] args){
		int fee;
		double discount;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the fee amount : ");
		 fee = sc.nextInt();
		 System.out.println ("Enter the discount :  ");
		 discount = sc.nextDouble();

		 int discountamount = (int) (fee * discount / 100);
		 int finalFee = fee - discountamount;

		 System.out.println ("The discount amount is INR "+ discountamount + ". and final discounted fee is INR " + finalFee + ".");
		 sc.close();

	}
}