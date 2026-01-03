package com.encapsulationandpolymorphism.employeemanagementsystem;

/*
 * Department interface
 * ---------------------
 * This interface defines department-related behavior.
 * Any class implementing this must provide its own
 * implementation for assigning and displaying department details.
 */
public interface Department {

    // Assigns a department name to an employee
    void assignDepartment(String departmentName);

    // Displays department information
    void getDepartmentDetails();
}
