package interfaces.implementinterfaces.smartdevicecontrol;

public class AC implements Switch {
	public void turnOn() {
		System.out.println("AC ON");
	}
	
	public void turnOff() {
		System.out.println("AC OFF");
	}
}
