package interfaces.implementinterfaces.smartdevicecontrol;

public class TV implements Switch {
	public void turnOn() {
		System.out.println("TV ON");
	}
	
	public void turnOff() {
		System.out.println("TV OFF");
	}
}
