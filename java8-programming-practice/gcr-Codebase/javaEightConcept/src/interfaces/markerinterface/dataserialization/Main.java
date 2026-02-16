package interfaces.markerinterface.dataserialization;

public class Main {

    public static void main(String[] args) {

        UserData user = new UserData("John");
        String normalObject = "Hello";

        BackupService.backup(user);
        BackupService.backup(normalObject);
    }
}
