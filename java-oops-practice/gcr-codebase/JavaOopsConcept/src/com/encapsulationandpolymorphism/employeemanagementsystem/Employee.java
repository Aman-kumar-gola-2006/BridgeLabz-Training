package com.encapsulationandpolymorphism.employeemanagementsystem;

/*
 * Abstract Employee class
 * -----------------------
 * This is the base class for all types of employees.
 * It demonstrates encapsulation and abstraction.
 */
abstract public class Employee implements Department {

    // Private variables for data protection (encapsulation)
    private int employeeId;
    private String name;

    // Protected so subclasses can access salary directly
    protected int baseSalary;

    // Stores department name of the employee
    String departmentname;

    // Constructor to initialize common employee details
    public Employee(int employeeId, String name, int baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Assigns a department to the employee
    @Override
    public void assignDepartment(String departmentName) {
        this.departmentname = departmentName;
    }

    // Displays department information
    @Override
    public void getDepartmentDetails() {
        System.out.println("The department is : " + departmentname);
    }

    /*
     * Abstract method for salary calculation
     * Each employee type will have its own logic
     */
    abstract double calculateSalary();

    // Displays complete employee information
    void displayDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee's salary is : " + calculateSalary());
        System.out.println("Employee Department is : " + departmentname);
        System.out.println("----------------------------------");
    }
}
