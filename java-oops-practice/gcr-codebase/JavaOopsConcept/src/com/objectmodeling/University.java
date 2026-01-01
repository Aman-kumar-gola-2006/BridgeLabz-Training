package com.objectmodeling;

import java.util.ArrayList;

/**
 * University class
 * ----------------
 * - Composition: University HAS Departments
 * - Aggregation: University HAS Faculty
 */
class University {

    private String universityName;

    // Composition: Departments cannot exist without University
    private ArrayList<Departmentfaculty> departments;

    // Aggregation: Faculty can exist independently
    private ArrayList<Faculty> faculties;

    // Constructor
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Add department (Composition)
    public void addDepartment(Departmentfaculty department) {
        departments.add(department);
    }

    // Add faculty (Aggregation)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display university structure
    public void displayUniversity() {
        System.out.println("\nUniversity: " + universityName);
        System.out.println("==========================");

        System.out.println("\nDepartments:");
        for (Departmentfaculty dept : departments) {
            dept.displayDepartment();
        }

        System.out.println("\nAll Faculty Members:");
        for (Faculty faculty : faculties) {
            faculty.displayFaculty();
            System.out.println();
        }
    }

    // Main method (Driver class)
    public static void main(String[] args) {

        // Create Faculty members (Independent objects)
        Faculty f1 = new Faculty(101, "Dr. Sharma");
        Faculty f2 = new Faculty(102, "Dr. Mehta");
        Faculty f3 = new Faculty(103, "Dr. Khan");

        // Create University
        University university = new University("National Technical University");

        // Create Departments (Dependent on University)
        Departmentfaculty csDept = new Departmentfaculty("Computer Science");
        Departmentfaculty mechDept = new Departmentfaculty("Mechanical Engineering");

        // Add faculty to university (Aggregation)
        university.addFaculty(f1);
        university.addFaculty(f2);
        university.addFaculty(f3);

        // Add faculty to departments
        csDept.addFaculty(f1);
        csDept.addFaculty(f3);

        mechDept.addFaculty(f2);

        // Add departments to university (Composition)
        university.addDepartment(csDept);
        university.addDepartment(mechDept);

        // Display university structure
        university.displayUniversity();

        // Deleting university
        university = null;
        System.out.println("\nUniversity deleted. All departments are destroyed.");

        // Faculty still exists independently
        System.out.println("\nFaculty still exists independently:");
        f1.displayFaculty();
    }
}