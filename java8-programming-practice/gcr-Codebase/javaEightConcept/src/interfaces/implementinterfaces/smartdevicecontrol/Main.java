package interfaces.implementinterfaces.smartdevicecontrol;

public class Main {
	public static void main(String[] args) {
		Switch l1=new Lights();
		l1.turnOn();
		l1.turnOff();
		
		Switch ac = new AC();
		ac.turnOn();
		ac.turnOff();
		
		Switch tv = new TV();
		tv.turnOn();
		tv.turnOff();
	}
	
}
