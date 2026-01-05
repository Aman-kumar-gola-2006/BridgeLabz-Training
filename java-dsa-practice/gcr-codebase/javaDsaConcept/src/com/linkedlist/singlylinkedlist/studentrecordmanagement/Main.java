package com.linkedlist.singlylinkedlist.studentrecordmanagement;
import java.util.*;
public class Main {
	
	    public static void main(String[] args) {

	        StudentManagement list = new StudentManagement();
	        Scanner sc = new Scanner(System.in);

	        int choice;

	        do {
	            System.out.println("\n----- STUDENT LINKED LIST MENU -----");
	            System.out.println("1. Add Student at Beginning");
	            System.out.println("2. Add Student at End");
	            System.out.println("3. Add Student at Position");
	            System.out.println("4. Delete Student by Roll No");
	            System.out.println("5. Search Student by Roll No");
	            System.out.println("6. Update Student Grade");
	            System.out.println("7. Display All Students");
	            System.out.println("8. Exit");
	            System.out.print("Enter choice: ");

	            choice = sc.nextInt();

	            try {
	                switch (choice) {
	                    case 1 -> {
	                        System.out.print("Roll No: ");
	                        int r = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Name: ");
	                        String n = sc.nextLine();
	                        System.out.print("Age: ");
	                        int a = sc.nextInt();
	                        System.out.print("Grade: ");
	                        char g = sc.next().charAt(0);
	                        list.insertAtBeginning(r, n, a, g);
	                    }

	                    case 2 -> {
	                        System.out.print("Roll No: ");
	                        int r = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Name: ");
	                        String n = sc.nextLine();
	                        System.out.print("Age: ");
	                        int a = sc.nextInt();
	                        System.out.print("Grade: ");
	                        char g = sc.next().charAt(0);
	                        list.insertAtEnd(r, n, a, g);
	                    }

	                    case 3 -> {
	                        System.out.print("Position: ");
	                        int pos = sc.nextInt();
	                        System.out.print("Roll No: ");
	                        int r = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Name: ");
	                        String n = sc.nextLine();
	                        System.out.print("Age: ");
	                        int a = sc.nextInt();
	                        System.out.print("Grade: ");
	                        char g = sc.next().charAt(0);
	                        list.insertAtPosition(r, n, a, g, pos);
	                    }

	                    case 4 -> {
	                        System.out.print("Enter Roll No to delete: ");
	                        list.delete(choice);
	                    }

	                    case 5 -> {
	                        System.out.print("Enter Roll No to search: ");
	                        list.searchByRollnumber(choice);
	                    }

	                    case 6 -> {
	                        System.out.print("Enter Roll No: ");
	                        int r = sc.nextInt();
	                        System.out.print("New Grade: ");
	                        char g = sc.next().charAt(0);
	                        list.updateGrade(r, g);
	                    }

	                    case 7 -> list.displayAll();
	                    case 8 -> System.out.println("Exiting program...");
	                    default -> System.out.println("Invalid choice!");
	                }
	            } catch (Exception e) {
	                System.out.println("Error: Invalid input");
	                sc.nextLine();
	            }

	        } while (choice != 8);

	        sc.close();
	    }
	


}
