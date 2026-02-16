package interfaces.implementinterfaces.multivehiclerental;

public class MultiVehicleRentalSystem {
	public static void main(String[] args) {
		Vehicle car = new Cars();
		car.rent();
		car.returnVehicle();
		
		Vehicle bike =  new Bikes();
		bike.rent();
		bike.returnVehicle();
		
		Vehicle bus = new Buses();
		bus.rent();
		bus.returnVehicle();
	}
}
