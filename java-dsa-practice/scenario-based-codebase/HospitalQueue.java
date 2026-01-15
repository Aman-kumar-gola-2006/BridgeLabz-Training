import java.util.*;

class Patient {
    String name;
    int criticality; // 1–10 (10 = most critical)

    public Patient(String name, int criticality) {
        this.name = name;
        this.criticality = criticality;
    }
}

public class HospitalQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Patient[] patients = new Patient[n];

        // Taking patient details from user
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for patient " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Criticality (1-10): ");
            int crit = sc.nextInt();
            sc.nextLine();

            patients[i] = new Patient(name, crit);
        }

        // Bubble Sort by criticality (descending)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (patients[j].criticality < patients[j + 1].criticality) {
                    // Swap
                    Patient temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }

        // Display Sorted Patients
        System.out.println("\nPatients sorted by criticality (highest first):");
        for (Patient p : patients) {
            System.out.println("Name: " + p.name + " | Criticality: " + p.criticality);
        }
    }
}
