package interfaces.implementinterfaces.smartdevicecontrol;

public class Lights implements Switch {
	@Override
	public void turnOn() {
		System.out.println("Lights ON");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Lights OFF");
	}
}
