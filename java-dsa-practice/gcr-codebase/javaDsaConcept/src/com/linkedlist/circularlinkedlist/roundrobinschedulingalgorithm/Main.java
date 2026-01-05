package com.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;
import java.util.Scanner;

public class Main {
	

	    static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {

	        System.out.print("Enter Time Quantum: ");
	        int tq = sc.nextInt();

	        RoundRobinScheduler scheduler = new RoundRobinScheduler(tq);

	        int choice;
	        do {
	            menu();
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1 -> addProcess(scheduler);
	                case 2 -> scheduler.simulate();
	                case 0 -> System.out.println("Exiting Scheduler...");
	                default -> System.out.println("Invalid choice");
	            }
	        } while (choice != 0);
	    }

	    static void menu() {
	        System.out.println("\n--- ROUND ROBIN MENU ---");
	        System.out.println("1. Add Process");
	        System.out.println("2. Run Scheduler");
	        System.out.println("0. Exit");
	        System.out.print("Enter choice: ");
	    }

	    static void addProcess(RoundRobinScheduler scheduler) {
	        System.out.print("Process ID: ");
	        int pid = sc.nextInt();
	        System.out.print("Burst Time: ");
	        int burst = sc.nextInt();
	        System.out.print("Priority: ");
	        int priority = sc.nextInt();

	        scheduler.addProcess(pid, burst, priority);
	    }
	}
