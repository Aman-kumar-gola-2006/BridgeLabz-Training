package interfaces.implementinterfaces.digitalpaymentinterface;

public class Wallet implements Payment {
	public void pay() {
		System.out.println("Paid by Wallet");
	}
}
