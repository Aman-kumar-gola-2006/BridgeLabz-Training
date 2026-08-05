package com.healthclinic.model;

public class Doctor {
    
    private int doctorId;
    private String name;
    private String specialty;
    private int departmentId;
    
    // Default constructor
    public Doctor() {}
    
    // Constructor without ID (for insert)
    public Doctor(String name, String specialty, int departmentId) {
        this.name = name;
        this.specialty = specialty;
        this.departmentId = departmentId;
    }
    
    // Constructor with ID (for select)
    public Doctor(int doctorId, String name, String specialty, int departmentId) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
        this.departmentId = departmentId;
    }
    
    // Getter for doctorId
    public int getDoctorId() {
        return doctorId;
    }
    
    // Setter for doctorId
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter for specialty
    public String getSpecialty() {
        return specialty;
    }
    
    // Setter for specialty
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    // Getter for departmentId
    public int getDepartmentId() {
        return departmentId;
    }
    
    // Setter for departmentId
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    
    @Override
    public String toString() {
        return "Doctor ID: " + doctorId + 
               " | Name: " + name + 
               " | Specialty: " + specialty + 
               " | Department ID: " + departmentId;
    }
}