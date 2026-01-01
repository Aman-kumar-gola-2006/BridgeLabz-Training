package com.objectmodeling;

import java.util.ArrayList;

class Doctor {

    private int doctorId;
    private String doctorName;
    private ArrayList<Patient> patients; // Association

    // Constructor
    public Doctor(int doctorId, String doctorName) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.patients = new ArrayList<>();
    }

    // Doctor consults a patient (communication)
    public void consult(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);

        System.out.println("🩺 Consultation:");
        System.out.println("Doctor  : " + doctorName);
        System.out.println("Patient : " + patient.getPatientName());
        System.out.println("Status  : Consultation completed\n");
    }

    // Display patients consulted by this doctor
    public void viewPatients() {
        System.out.println("Doctor " + doctorName + " has consulted:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getPatientName());
        }
        System.out.println();
    }

    // Getter
    public String getDoctorName() {
        return doctorName;
    }
}