package com.objectmodeling;

class Employee {

    private String empName;
    private int empId;

    // Constructor
    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    // Display employee details
    public void displayEmployee() {
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
    }
}