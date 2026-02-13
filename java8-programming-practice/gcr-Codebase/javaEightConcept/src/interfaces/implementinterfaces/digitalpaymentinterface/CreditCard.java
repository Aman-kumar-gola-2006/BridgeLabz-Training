package interfaces.implementinterfaces.digitalpaymentinterface;

public class CreditCard implements Payment {
	public void pay() {
		System.out.println("Paid By Credit Card");
	}
}
