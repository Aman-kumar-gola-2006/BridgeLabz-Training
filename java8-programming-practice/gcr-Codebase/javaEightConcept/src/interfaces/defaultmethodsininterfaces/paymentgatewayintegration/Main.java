package interfaces.defaultmethodsininterfaces.paymentgatewayintegration;

public class Main {
	public static void main(String[] args) {
		PaymentProcessor payment = new UPIPayment();
		
		payment.pay(300);
		
		// default method
		payment.refund(100);
	}
}
