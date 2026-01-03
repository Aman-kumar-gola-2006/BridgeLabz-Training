package com.encapsulationandpolymorphism.employeemanagementsystem;

/*
 * PartTimeEmployee class
 * ----------------------
 * Represents an employee paid on an hourly basis.
 * Salary is calculated using hourly rate and total hours worked.
 */
public class PartTimeEmployee extends Employee {

    // Hourly pay rate
    double hourlyRates;

    // Total hours worked
    double totalHours;

    // Constructor initializes both common and specific fields
    public PartTimeEmployee(int employeeId, String name, int baseSalary,
                            double hourlyRates, double totalHours) {
        super(employeeId, name, baseSalary);
        this.hourlyRates = hourlyRates;
        this.totalHours = totalHours;
    }

    // Salary calculation for part-time employees
    @Override
    double calculateSalary() {
        return baseSalary + (hourlyRates * totalHours);
    }
}
