package com.objectmodeling;
import java.util.ArrayList;

class Company {

    private String companyName;
    private ArrayList<Department> departments;

    // Constructor
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Add department to company
    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    // Display company structure
    public void displayCompany() {
        System.out.println("\nCompany Name: " + companyName);
        System.out.println("==========================");

        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }
    
    public static void main(String[] args) {
		Company company= new Company("Xyz private limited");
		Department department=new Department("IT");
		department.addEmployee(003, "Anuj");
		department.addEmployee(001, "Arun");
		company.addDepartment(department);
		department.addEmployee(002,"Harsh");
		department.displayDepartment();
	
		Department department2=new Department("Sales");
		department2.addEmployee(0203, "Anuj");
		department2.addEmployee(0501, "Arun");
		company.addDepartment(department);
		department2.addEmployee(0102,"Harsh");
		department2.displayDepartment();
		
	}
}