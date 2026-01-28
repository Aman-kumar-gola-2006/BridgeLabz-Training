package com.mapinterface.groupobjectsbyproperty;

import java.util.*;

public class GroupEmployees {

    public static void main(String[] args) {

        // Create employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        // Map to group employees by department
        Map<String, List<Employee>> groupByDepartment = new HashMap<>();

        /*
         * Group employees
         */
        for (Employee emp : employees) {

            String dept = emp.department;

            // If department not present, create a new list
            if (!groupByDepartment.containsKey(dept)) {
                groupByDepartment.put(dept, new ArrayList<>());
            }

            // Add employee to department list
            groupByDepartment.get(dept).add(emp);
        }

        // Display grouped employees
        for (Map.Entry<String, List<Employee>> entry : groupByDepartment.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
