package interfaces.implementinterfaces.multivehiclerental;

public class Bikes implements Vehicle {
	
	public void rent() {
		System.out.println("Bike Has been rented");
	}
	
	public void returnVehicle() {
		System.out.println("Bike Has been returned");
	}
	
}
