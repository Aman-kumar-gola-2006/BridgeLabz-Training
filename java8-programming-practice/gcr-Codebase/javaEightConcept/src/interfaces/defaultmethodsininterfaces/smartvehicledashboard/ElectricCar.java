package interfaces.defaultmethodsininterfaces.smartvehicledashboard;

public class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Electric car speed: 70 km/h");
    }

    @Override
    public void displayBattery() {
        System.out.println("Battery level: 65%");
    }
}
