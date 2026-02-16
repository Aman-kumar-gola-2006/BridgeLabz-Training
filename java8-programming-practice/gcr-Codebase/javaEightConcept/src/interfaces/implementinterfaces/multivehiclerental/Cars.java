package interfaces.implementinterfaces.multivehiclerental;

public class Cars implements Vehicle {
	
	@Override
	public void rent() {
		System.out.println("Car Has been rented");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Car Has Been Returned");
	}
}
