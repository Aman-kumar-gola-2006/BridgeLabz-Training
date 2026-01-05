package com.linkedlist.circularlinkedlist.taskschedular;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n----- TASK SCHEDULER MENU -----");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Search Task by Priority");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    int dueDate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    scheduler.addAtBeginning(id, name, dueDate, priority);
                }

                case 2 -> {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    int dueDate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    scheduler.addAtEnd(id, name, dueDate, priority);
                }

                case 3 -> {
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    int dueDate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    scheduler.addAtPosition(pos, id, name, dueDate, priority);
                }

                case 4 -> {
                    System.out.print("Enter Task ID to Remove: ");
                    int id = sc.nextInt();
                    scheduler.removeById(id);
                }

                case 5 -> scheduler.viewNextTask();

                case 6 -> {
                    System.out.print("Enter Priority to Search: ");
                    String priority = sc.nextLine();
                    scheduler.searchByPriority(priority);
                }

                case 7 -> scheduler.displayAll();

                case 8 -> System.out.println("Exiting Task Scheduler...");

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
