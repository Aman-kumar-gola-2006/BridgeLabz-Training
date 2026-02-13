package interfaces.markerinterface.cloningprototype;

public class Prototype implements Cloneable {

    int value = 10;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
