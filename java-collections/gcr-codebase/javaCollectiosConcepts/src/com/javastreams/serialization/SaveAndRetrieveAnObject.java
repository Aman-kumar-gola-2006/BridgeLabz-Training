package com.javastreams.serialization;

import java.util.*;
public class SaveAndRetrieveAnObject {
	 public static void main(String[] args) {

	        String fileName = "employees.dat";

	        // Create employee list
	        List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee(101, "Shifa", "IT", 55000));
	        employees.add(new Employee(102, "Ayaan", "HR", 48000));
	        employees.add(new Employee(103, "Neha", "Finance", 62000));

	        // Serialize
	        EmployeeSerializer.serializeEmployees(employees, fileName);

	        // Deserialize
	        EmployeeDeserializer.deserializeEmployees(fileName);
	    }
}