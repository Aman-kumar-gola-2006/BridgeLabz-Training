import java.util.*;

// Interface for common device actions
interface IControllable {
    void turnOn();
    void turnOff();
    void reset();
}

// Base class with Encapsulation
abstract class Device implements IControllable {
    private String deviceId;
    private boolean status;
    protected int energyUsage;   // in watts (example)

    // Private firmware log (secured)
    private String firmwareLog = "";

    // Constructor
    public Device(String deviceId, int energyUsage) {
        this.deviceId = deviceId;
        this.energyUsage = energyUsage;
        this.status = false;
        addFirmwareLog("Device " + deviceId + " registered.");
    }

    // Encapsulated getter
    public String getDeviceId() {
        return deviceId;
    }

    public boolean isOn() {
        return status;
    }

    // Encapsulated status change
    protected void setStatus(boolean newStatus) {
        status = newStatus;
    }

    // Energy usage calculation using operators
    public int calculateEnergy(int hours) {
        return energyUsage * hours;         // Watts × Hours
    }

    // Secure firmware log
    protected void addFirmwareLog(String msg) {
        firmwareLog += msg + "\n";
    }

    public void showFirmwareLog() {
        System.out.println(firmwareLog);
    }
}

// Subclass 1: Light
class Light extends Device {
    public Light(String deviceId) {
        super(deviceId, 10); // 10 watts example
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Light " + getDeviceId() + " turned ON.");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Light " + getDeviceId() + " turned OFF.");
    }

    // Polymorphism
    public void reset() {
        System.out.println("Light " + getDeviceId() + " reset to default brightness.");
    }
}

// Subclass 2: Camera
class Camera extends Device {
    public Camera(String deviceId) {
        super(deviceId, 15);
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Camera " + getDeviceId() + " activated.");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Camera " + getDeviceId() + " deactivated.");
    }

    public void reset() {
        System.out.println("Camera " + getDeviceId() + " reset to motion-detection mode.");
    }
}

// Subclass 3: Thermostat
class Thermostat extends Device {
    public Thermostat(String deviceId) {
        super(deviceId, 25);
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Thermostat " + getDeviceId() + " is now ON.");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Thermostat " + getDeviceId() + " turned OFF.");
    }

    public void reset() {
        System.out.println("Thermostat " + getDeviceId() + " reset to 24°C.");
    }
}

// Subclass 4: Lock
class Lock extends Device {
    public Lock(String deviceId) {
        super(deviceId, 5);
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Lock " + getDeviceId() + " is locked.");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Lock " + getDeviceId() + " is unlocked.");
    }

    public void reset() {
        System.out.println("Lock " + getDeviceId() + " reset to secure mode.");
    }
}

// Main class
public class HomeNest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Device> devices = new ArrayList<>();

        System.out.println("Register your HomeNest devices:");
        System.out.println("1. Light\n2. Camera\n3. Thermostat\n4. Lock\n5. Done");

        while (true) {
            System.out.print("Choose device to add: ");
            int choice = sc.nextInt();

            if (choice == 5) break;

            System.out.print("Enter device ID: ");
            String id = sc.next();

            switch (choice) {
                case 1:
                    devices.add(new Light(id));
                    break;
                case 2:
                    devices.add(new Camera(id));
                    break;
                case 3:
                    devices.add(new Thermostat(id));
                    break;
                case 4:
                    devices.add(new Lock(id));
                    break;
                default:
                    System.out.println("Invalid device type.");
            }
        }

        // Control loop
        while (true) {
            System.out.println("\n1. Turn ON device");
            System.out.println("2. Turn OFF device");
            System.out.println("3. Reset device");
            System.out.println("4. Show energy usage");
            System.out.println("5. View Firmware Logs");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int op = sc.nextInt();

            if (op == 6) break;

            System.out.print("Enter device ID: ");
            String id = sc.next();

            Device selected = null;

            for (Device d : devices) {
                if (d.getDeviceId().equals(id)) {
                    selected = d;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Device not found.");
                continue;
            }

            switch (op) {
                case 1:
                    selected.turnOn();
                    break;
                case 2:
                    selected.turnOff();
                    break;
                case 3:
                    selected.reset();
                    break;
                case 4:
                    System.out.print("Enter hours: ");
                    int h = sc.nextInt();
                    System.out.println("Energy used: " + selected.calculateEnergy(h) + " Wh");
                    break;
                case 5:
                    selected.showFirmwareLog();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
