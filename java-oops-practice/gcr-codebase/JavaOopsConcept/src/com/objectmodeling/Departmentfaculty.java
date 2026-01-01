package com.objectmodeling;
import java.util.ArrayList;

public class Departmentfaculty {
	
	

	    private String departmentName;
	    private ArrayList<Faculty> facultyList;

	    // Constructor
	    public Departmentfaculty(String departmentName) {
	        this.departmentName = departmentName;
	        this.facultyList = new ArrayList<>();
	    }

	    // Add faculty to department (aggregation)
	    public void addFaculty(Faculty faculty) {
	        facultyList.add(faculty);
	    }

	    // Display department details
	    public void displayDepartment() {
	        System.out.println("\nDepartment: " + departmentName);
	        System.out.println("Faculty Members:");
	        for (Faculty faculty : facultyList) {
	            System.out.println("- " + faculty.getFacultyName());
	        }
	    }
	}