package interfaces.implementinterfaces.multivehiclerental;

public class Buses implements Vehicle {

	@Override
	public void rent() {
		System.out.println("Bus has been rented");
	}

	@Override
	public void returnVehicle() {
		System.out.println("Bus has been returned");
	}
}
