package com.objectmodeling;

import java.util.ArrayList;

class Hospital {

    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // Constructor
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add doctor to hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Add patient to hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Display hospital details
    public void displayHospital() {
        System.out.println("\nHospital: " + hospitalName);
        System.out.println("==========================");
        System.out.println("Doctors Count : " + doctors.size());
        System.out.println("Patients Count: " + patients.size());
    }
    
    public static void main(String[] args) {

        // Create Hospital
        Hospital hospital = new Hospital("City Care Hospital");

        // Create Doctors
        Doctor d1 = new Doctor(101, "Dr. Verma");
        Doctor d2 = new Doctor(102, "Dr. Khan");

        // Create Patients
        Patient p1 = new Patient(201, "Rohit");
        Patient p2 = new Patient(202, "Anita");

        // Add doctors and patients to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Doctor-patient consultations (communication)
        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p1);

        // View relationships
        d1.viewPatients();
        d2.viewPatients();

        p1.viewDoctors();
        p2.viewDoctors();

        hospital.displayHospital();
    }
}