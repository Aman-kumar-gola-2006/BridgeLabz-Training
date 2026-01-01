package com.objectmodeling;


import java.util.ArrayList;

class Department {

    private String departmentName;
    private ArrayList<Employee> employees;

    // Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    // Add employee to department
    public void addEmployee(int id, String name) {
        Employee emp = new Employee(id, name);
        employees.add(emp);
    }

    // Display department details
    public void displayDepartment() {
        System.out.println("\nDepartment: " + departmentName);
        System.out.println("----------------------");

        // for loop to print the employee details
        for (Employee emp : employees) {
            emp.displayEmployee();
            System.out.println();
        }
    }
   }