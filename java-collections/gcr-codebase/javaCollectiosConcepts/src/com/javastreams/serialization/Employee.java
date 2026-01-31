package com.javastreams.serialization;

import java.io.Serializable;

/**
 * Employee class represents employee details
 * Implements Serializable to allow object serialization
 */
class Employee implements Serializable {

    // Recommended for Serializable classes
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id +
               ", Name=" + name +
               ", Department=" + department +
               ", Salary=" + salary + "]";
    }
}