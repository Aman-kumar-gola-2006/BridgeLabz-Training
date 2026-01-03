package com.encapsulationandpolymorphism.hospitalpatientmanagement;

/*
 * OutPatient class
 * ----------------
 * Represents patients visiting for consultation only.
 */
public class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;
    private double testCharges;

    public OutPatient(int patientId, String name, int age, String diagnosis,
                      double consultationFee, double testCharges) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
        this.testCharges = testCharges;
    }

    // Bill calculation for out-patients
    @Override
    public double calculateBill() {
        return consultationFee + testCharges;
    }

    @Override
    public void addRecord(String record) {
        addMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

