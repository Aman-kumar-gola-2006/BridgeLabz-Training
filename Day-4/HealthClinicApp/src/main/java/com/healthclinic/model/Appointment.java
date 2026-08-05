package com.healthclinic.model;

import java.sql.Timestamp;

public class Appointment {
    
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Timestamp appointmentDate;
    private String status;
    
    // Default constructor
    public Appointment() {}
    
    // Constructor without ID (for insert)
    public Appointment(int patientId, int doctorId, Timestamp appointmentDate, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
    
    // Constructor with ID (for select)
    public Appointment(int appointmentId, int patientId, int doctorId, 
                      Timestamp appointmentDate, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
    
    // Getter for appointmentId
    public int getAppointmentId() {
        return appointmentId;
    }
    
    // Setter for appointmentId
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    // Getter for patientId
    public int getPatientId() {
        return patientId;
    }
    
    // Setter for patientId
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    // Getter for doctorId
    public int getDoctorId() {
        return doctorId;
    }
    
    // Setter for doctorId
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    
    // Getter for appointmentDate
    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }
    
    // Setter for appointmentDate
    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    // Getter for status
    public String getStatus() {
        return status;
    }
    
    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + 
               " | Patient ID: " + patientId + 
               " | Doctor ID: " + doctorId + 
               " | Date: " + appointmentDate + 
               " | Status: " + status;
    }
}