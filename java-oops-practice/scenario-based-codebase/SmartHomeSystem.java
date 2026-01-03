// Interface
interface Controllable {
    void turnOn();
    void turnOff();
}

// ---------------- Appliance Class ----------------
class Appliance {
    private boolean status;
    protected int powerUsage;

    Appliance(int powerUsage) {
        this.powerUsage = powerUsage;
        this.status = false;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }

    protected boolean getStatus() {
        return status;
    }

    protected int getPowerUsage() {
        return powerUsage;
    }
}

// ---------------- Light Class ----------------
class Light extends Appliance implements Controllable {

    Light() {
        super(40); // 40W
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Light turned ON (Power: 40W)");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Light turned OFF");
    }
}

// ---------------- Fan Class ----------------
class Fan extends Appliance implements Controllable {

    Fan() {
        super(75); // 75W
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Fan turned ON (Power: 75W)");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Fan turned OFF");
    }
}

// ---------------- AC Class ----------------
class AC extends Appliance implements Controllable {

    AC() {
        super(1500); // 1500W
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("AC turned ON (Power: 1500W)");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("AC turned OFF");
    }
}

// ---------------- User Controller ----------------
class UserController {

    void operateDevice(Controllable device) {
        device.turnOn();
    }

    void stopDevice(Controllable device) {
        device.turnOff();
    }

    void comparePower(Appliance a1, Appliance a2) {
        if (a1.getPowerUsage() > a2.getPowerUsage())
            System.out.println("First device consumes more power.");
        else if (a1.getPowerUsage() < a2.getPowerUsage())
            System.out.println("Second device consumes more power.");
        else
            System.out.println("Both devices consume equal power.");
    }
}

// ---------------- Main Class ----------------
public class SmartHomeSystem {

    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();

        UserController user = new UserController();

        System.out.println("---- TURNING ON DEVICES ----");
        user.operateDevice(light);
        user.operateDevice(fan);
        user.operateDevice(ac);

        System.out.println("\n---- POWER COMPARISON ----");
        user.comparePower(fan, ac);

        System.out.println("\n---- TURNING OFF DEVICES ----");
        user.stopDevice(light);
        user.stopDevice(ac);
    }
}
