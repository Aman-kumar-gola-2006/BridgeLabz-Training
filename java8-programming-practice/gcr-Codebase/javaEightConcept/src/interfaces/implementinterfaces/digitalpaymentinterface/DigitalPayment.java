package interfaces.implementinterfaces.digitalpaymentinterface;

public class DigitalPayment {
	public static void main(String[] args) {
		Payment upi = new UPI();
		upi.pay();
		
		Payment creditCard = new CreditCard();
		creditCard.pay();
		
		Payment wallet = new Wallet();
		wallet.pay();
	}
}
