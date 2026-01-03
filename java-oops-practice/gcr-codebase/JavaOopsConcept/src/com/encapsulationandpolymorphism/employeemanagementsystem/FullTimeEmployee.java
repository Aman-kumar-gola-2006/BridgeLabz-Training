package com.encapsulationandpolymorphism.employeemanagementsystem;

/*
 * FullTimeEmployee class
 * ----------------------
 * Represents a permanent employee.
 * Salary is fixed and equals the base salary.
 */
public class FullTimeEmployee extends Employee {

    // Constructor passes values to the parent class
    public FullTimeEmployee(int employeeId, String name, int baseSalary) {
        super(employeeId, name, baseSalary);
    }

    // Salary calculation for full-time employees
    @Override
    double calculateSalary() {
        return baseSalary;
    }
}
