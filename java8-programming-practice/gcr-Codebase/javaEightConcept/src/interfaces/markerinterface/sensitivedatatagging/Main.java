package interfaces.markerinterface.sensitivedatatagging;

public class Main {

    public static void main(String[] args) {

        CustomerInfo customer = new CustomerInfo();
        String publicData = "Public Info";

        SecurityService.process(customer);
        SecurityService.process(publicData);
    }
}
