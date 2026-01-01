package com.objectmodeling;

import java.util.ArrayList;

class Patient {

    private int patientId;
    private String patientName;
    private ArrayList<Doctor> doctors; // Association

    // Constructor
    public Patient(int patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctors = new ArrayList<>();
    }

    // Add doctor to patient's consultation list
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Display doctors consulted by patient
    public void viewDoctors() {
        System.out.println("Patient " + patientName + " consulted:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getDoctorName());
        }
        System.out.println();
    }

    // Getter
    public String getPatientName() {
        return patientName;
    }
}