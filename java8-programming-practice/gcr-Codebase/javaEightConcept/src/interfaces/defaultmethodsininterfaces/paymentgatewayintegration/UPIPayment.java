package interfaces.defaultmethodsininterfaces.paymentgatewayintegration;

public class UPIPayment implements PaymentProcessor {
	@Override
	public void pay(double amount) {
		System.out.println("Paid " + amount + " Using UPI");
	}
}
