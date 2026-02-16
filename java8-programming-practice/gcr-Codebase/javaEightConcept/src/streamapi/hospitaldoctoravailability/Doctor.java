package streamapi.hospitaldoctoravailability;

public class Doctor {

    private int id;
    private String name;
    private String specialty;
    private boolean availableOnWeekend;

    public Doctor(int id, String name, String specialty, boolean availableOnWeekend) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    // Getter for doctor id
    public int getId() {
        return id;
    }

    // Getter for doctor name
    public String getName() {
        return name;
    }

    // Getter for doctor's specialty
    public String getSpecialty() {
        return specialty;
    }

    // Getter to check weekend availability
    public boolean isAvailableOnWeekend() {
        return availableOnWeekend;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id +
               ", name=" + name +
               ", specialty=" + specialty +
               ", availableOnWeekend=" + availableOnWeekend + "]";
    }
}
