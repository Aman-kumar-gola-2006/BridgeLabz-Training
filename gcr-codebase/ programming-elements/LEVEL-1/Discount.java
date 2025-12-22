public class Discount{
	public static void main(String[] args){
		int fee = 125000;
		int discountPercent  = 10;

		 int discountamount = fee * discountPercent / 100;
		 int finalFee = fee - discountamount;

		 System.out.println("The discountamount is INR " + discountamount + ". and final discounted fee is INR " + finalFee + ".");
		 
	}
}