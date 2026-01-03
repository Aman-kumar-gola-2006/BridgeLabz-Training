package com.encapsulationandpolymorphism.hospitalpatientmanagement;

import java.util.ArrayList;
import java.util.List;

/*
 * Abstract Patient class
 * ----------------------
 * Acts as a base class for all patient types.
 * Uses encapsulation to protect sensitive medical data.
 */
public abstract class Patient {

    // Encapsulated patient details
    private int patientId;
    private String name;
    private int age;

    // Sensitive medical information (restricted access)
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    // Constructor initializes common patient data
    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Read-only access using getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Diagnosis is masked for security
    protected String getMaskedDiagnosis() {
        return diagnosis.charAt(0) + "*****";
    }

    // Protected access to update medical history
    protected void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }

    /*
     * Abstract method for bill calculation.
     * Implemented differently for each patient type.
     */
    public abstract double calculateBill();

    // Displays common patient details
    public void getPatientDetails() {
        System.out.println("Patient ID    : " + patientId);
        System.out.println("Patient Name  : " + name);
        System.out.println("Age           : " + age);
        System.out.println("Diagnosis     : " + getMaskedDiagnosis());
    }
}
