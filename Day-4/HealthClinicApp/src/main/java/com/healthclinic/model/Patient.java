package com.healthclinic.model;

import java.sql.Date;

public class Patient {
    
    private int patientId;
    private String name;
    private String phone;
    private Date dob;
    private String gender;
    
    // Default constructor
    public Patient() {}
    
    // Constructor without ID (for insert)
    public Patient(String name, String phone, Date dob, String gender) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }
    
    // Constructor with ID (for select)
    public Patient(int patientId, String name, String phone, Date dob, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }
    
    // Getter for patientId
    public int getPatientId() {
        return patientId;
    }
    
    // Setter for patientId
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter for phone
    public String getPhone() {
        return phone;
    }
    
    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // Getter for dob
    public Date getDob() {
        return dob;
    }
    
    // Setter for dob
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    // Getter for gender
    public String getGender() {
        return gender;
    }
    
    // Setter for gender
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "Patient ID: " + patientId + 
               " | Name: " + name + 
               " | Phone: " + phone + 
               " | DOB: " + dob + 
               " | Gender: " + gender;
    }
}