package interfaces.markerinterface.dataserialization;

public class UserData implements BackupEligible {

    String name;

    public UserData(String name) {
        this.name = name;
    }
}
