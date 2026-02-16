package interfaces.markerinterface.sensitivedatatagging;

public class SecurityService {

    public static void process(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data");
        } else {
            System.out.println("No encryption needed");
        }
    }
}
