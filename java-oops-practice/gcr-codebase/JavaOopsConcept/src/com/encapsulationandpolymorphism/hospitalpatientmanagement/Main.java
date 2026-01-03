package com.encapsulationandpolymorphism.hospitalpatientmanagement;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism by handling
 * different patient types dynamically.
 */
public class Main {

    // Polymorphic method to process billing
    public static void processPatients(List<Patient> patients) {

        System.out.println("\n========== PATIENT BILLING SUMMARY ==========\n");

        for (Patient patient : patients) {

            patient.getPatientDetails();
            double billAmount = patient.calculateBill();

            System.out.println("Total Bill    : ₹" + billAmount);

            // Display medical records if supported
            if (patient instanceof MedicalRecord record) {
                record.viewRecords();
            }

            System.out.println("---------------------------------------------\n");
        }
    }

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        // -------- In-Patients (3 examples) --------
        InPatient p1 = new InPatient(101, "Abhay", 25, "Pneumonia", 5, 2000, 15000);
        p1.addRecord("Admitted to ICU");
        p1.addRecord("Antibiotics administered");

        InPatient p2 = new InPatient(102, "Riya", 30, "Appendicitis", 4, 1800, 12000);
        p2.addRecord("Surgery completed");
        p2.addRecord("Post-op observation");

        InPatient p3 = new InPatient(103, "Aman", 40, "Fracture", 6, 1500, 10000);
        p3.addRecord("X-ray taken");
        p3.addRecord("Physiotherapy started");

        // -------- Out-Patients (3 examples) --------
        OutPatient p4 = new OutPatient(201, "Neha", 22, "Fever", 500, 300);
        p4.addRecord("Prescribed medication");

        OutPatient p5 = new OutPatient(202, "Karan", 35, "Diabetes", 800, 1200);
        p5.addRecord("Blood sugar test done");

        OutPatient p6 = new OutPatient(203, "Simran", 28, "Migraine", 600, 400);
        p6.addRecord("MRI recommended");

        // Add all patients
        patients.add(p1);
        patients.add(p2);
        patients.add(p3);
        patients.add(p4);
        patients.add(p5);
        patients.add(p6);

        // Process all patients polymorphically
        processPatients(patients);
    }
}

