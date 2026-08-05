package com.healthclinic.model;

public class Department {
    
    private int departmentId;
    private String departmentName;
    
    // Default constructor
    public Department() {}
    
    // Constructor without ID (for insert)
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    
    // Constructor with ID (for select)
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    
    // Getter for departmentId
    public int getDepartmentId() {
        return departmentId;
    }
    
    // Setter for departmentId
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    
    // Getter for departmentName
    public String getDepartmentName() {
        return departmentName;
    }
    
    // Setter for departmentName
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    @Override
    public String toString() {
        return "Department ID: " + departmentId + 
               " | Name: " + departmentName;
    }
}