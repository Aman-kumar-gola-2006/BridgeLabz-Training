package com.encapsulationandpolymorphism.employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

/*
 * Main class
 * ----------
 * Demonstrates polymorphism using Employee references.
 * Both FullTimeEmployee and PartTimeEmployee are treated
 * as Employee objects.
 */
public class Main {

    public static void main(String[] args) {

        // Creating a list to store different types of employees
        List<Employee> employees = new ArrayList<>();

        // Creating full-time and part-time employee objects
        Employee employee1 = new FullTimeEmployee(1, "Abhay", 20000);
        Employee employee2 = new PartTimeEmployee(2, "Aman", 0, 500, 20);

        // Adding employees to the list
        employees.add(employee1);
        employees.add(employee2);

        // Assigning departments
        employee1.assignDepartment("IT");
        employee2.assignDepartment("HR");

        // Displaying employee details
        employee1.displayDetails();
        employee2.displayDetails();
    }
}
