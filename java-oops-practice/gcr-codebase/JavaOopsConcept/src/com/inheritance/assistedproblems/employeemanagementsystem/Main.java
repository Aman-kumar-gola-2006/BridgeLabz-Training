package com.inheritance.assistedproblems.employeemanagementsystem;

public class Main {

    public static void main(String[] args) {

        // Creating objects of different employee types
        Manager manager = new Manager("Alice", 101, 90000, 8);
        Developer developer = new Developer("Bob", 102, 70000, "Java");
        Intern intern = new Intern("Charlie", 103, 15000, 6);

        // Displaying details
        System.out.println("Manager Details:");
        manager.displayDetails();

        System.out.println("\nDeveloper Details:");
        developer.displayDetails();

        System.out.println("\nIntern Details:");
        intern.displayDetails();
    }

}