// Interface
interface Payable {
    double calculatePayment();
}

// -------------------- Patient Class --------------------
class Patient {
    private String name;
    private int age;
    private String medicalHistory;

    // Constructor
    Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    // Getter (Encapsulation)
    public String getSummary() {
        return "Name: " + name + ", Age: " + age;
    }

    public void displayInfo() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
    }
}

// -------------------- InPatient --------------------
class InPatient extends Patient {
    int daysAdmitted;

    InPatient(String name, int age, String history, int days) {
        super(name, age, history);
        this.daysAdmitted = days;
    }

    @Override
    public void displayInfo() {
        System.out.println("In-Patient");
        super.displayInfo();
        System.out.println("Days Admitted: " + daysAdmitted);
    }
}

// -------------------- OutPatient --------------------
class OutPatient extends Patient {

    OutPatient(String name, int age, String history) {
        super(name, age, history);
    }

    @Override
    public void displayInfo() {
        System.out.println("Out-Patient");
        super.displayInfo();
    }
}

// -------------------- Doctor Class --------------------
class Doctor {
    String name;
    String specialization;

    Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    void displayInfo() {
        System.out.println("Doctor Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

// -------------------- Bill Class --------------------
class Bill implements Payable {
    double consultationFee;
    double medicineCost;

    Bill(double consultationFee, double medicineCost) {
        this.consultationFee = consultationFee;
        this.medicineCost = medicineCost;
    }

    @Override
    public double calculatePayment() {
        double total = consultationFee + medicineCost;
        double discount = total * 0.10; // 10% discount
        return total - discount;
    }
}

// -------------------- Main Class --------------------
public class HospitalSystem {
    public static void main(String[] args) {

        // Patient
        InPatient p1 = new InPatient("Aman", 21, "Fever", 3);

        // Doctor
        Doctor d1 = new Doctor("Dr. Sharma", "Physician");

        // Bill
        Bill bill = new Bill(500, 1200);

        System.out.println("----- PATIENT DETAILS -----");
        p1.displayInfo();

        System.out.println("\n----- DOCTOR DETAILS -----");
        d1.displayInfo();

        System.out.println("\n----- BILL DETAILS -----");
        System.out.println("Total Amount to Pay: ₹" + bill.calculatePayment());
    }
}
