package interfaces.markerinterface.cloningprototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Prototype p1 = new Prototype();
        Prototype p2 = (Prototype) p1.clone();

        System.out.println("Cloned successfully");
    }
}
