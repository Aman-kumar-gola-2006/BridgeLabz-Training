package com.encapsulationandpolymorphism.hospitalpatientmanagement;

/*
 * InPatient class
 * ---------------
 * Represents patients admitted to the hospital.
 * Billing includes room charges and treatment costs.
 */
public class InPatient extends Patient implements MedicalRecord {

    private int numberOfDays;
    private double dailyRoomCharge;
    private double treatmentCost;

    public InPatient(int patientId, String name, int age, String diagnosis,
                     int numberOfDays, double dailyRoomCharge, double treatmentCost) {
        super(patientId, name, age, diagnosis);
        this.numberOfDays = numberOfDays;
        this.dailyRoomCharge = dailyRoomCharge;
        this.treatmentCost = treatmentCost;
    }

    // Bill calculation for in-patients
    @Override
    public double calculateBill() {
        return (numberOfDays * dailyRoomCharge) + treatmentCost;
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

