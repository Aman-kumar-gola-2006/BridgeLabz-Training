package interfaces.defaultmethodsininterfaces.smartvehicledashboard;

public interface Vehicle {
	void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery info not available");
    }
}
