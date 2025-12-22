public class Profitloss{
	public static void main(String [] args){
		int cost_price = 129;
		int selling_price = 191;

		int Profit = selling_price - cost_price;
		double ProfitPercentage = Profit * 100 /cost_price;	

		System.out.println("The Cost Price is INR  " + cost_price + "and selling_price in INR " + selling_price + ". The Profit is INR " + Profit + "and the ProfitPercentage is "+ ProfitPercentage);	
	}
}