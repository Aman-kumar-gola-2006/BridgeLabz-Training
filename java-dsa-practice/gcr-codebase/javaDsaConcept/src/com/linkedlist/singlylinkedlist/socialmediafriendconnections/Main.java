package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

import java.util.*;
public class Main {
	

	    static Scanner sc = new Scanner(System.in);
	    static SocialMedia sm = new SocialMedia();

	    public static void main(String[] args) {

	        int choice;
	        do {
	            menu();
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1 -> addUser();
	                case 2 -> addFriend();
	                case 3 -> removeFriend();
	                case 4 -> mutualFriends();
	                case 5 -> displayFriends();
	                case 6 -> searchUser();
	                case 7 -> sm.countFriends();
	                case 0 -> System.out.println("Exiting...");
	                default -> System.out.println("Invalid choice");
	            }
	        } while (choice != 0);
	    }

	    static void menu() {
	        System.out.println("\n--- SOCIAL MEDIA MENU ---");
	        System.out.println("1. Add User");
	        System.out.println("2. Add Friend Connection");
	        System.out.println("3. Remove Friend Connection");
	        System.out.println("4. Find Mutual Friends");
	        System.out.println("5. Display Friends of User");
	        System.out.println("6. Search User");
	        System.out.println("7. Count Friends of Each User");
	        System.out.println("0. Exit");
	        System.out.print("Enter choice: ");
	    }

	    static void addUser() {
	        System.out.print("User ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Name: ");
	        String name = sc.nextLine();
	        System.out.print("Age: ");
	        int age = sc.nextInt();
	        sm.addUser(id, name, age);
	    }

	    static void addFriend() {
	        System.out.print("Enter User1 ID: ");
	        int u1 = sc.nextInt();
	        System.out.print("Enter User2 ID: ");
	        int u2 = sc.nextInt();
	        sm.addFriendConnection(u1, u2);
	    }

	    static void removeFriend() {
	        System.out.print("Enter User1 ID: ");
	        int u1 = sc.nextInt();
	        System.out.print("Enter User2 ID: ");
	        int u2 = sc.nextInt();
	        sm.removeFriendConnection(u1, u2);
	    }

	    static void mutualFriends() {
	        System.out.print("Enter User1 ID: ");
	        int u1 = sc.nextInt();
	        System.out.print("Enter User2 ID: ");
	        int u2 = sc.nextInt();
	        sm.findMutualFriends(u1, u2);
	    }

	    static void displayFriends() {
	        System.out.print("Enter User ID: ");
	        sm.displayFriends(sc.nextInt());
	    }

	    static void searchUser() {
	        System.out.println("1. Search by ID\n2. Search by Name");
	        int ch = sc.nextInt();
	        sc.nextLine();

	        if (ch == 1) {
	            UserNode u = sm.searchById(sc.nextInt());
	            if (u != null)
	                System.out.println(u.name + ", Age: " + u.age);
	        } else {
	            UserNode u = sm.searchByName(sc.nextLine());
	            if (u != null)
	                System.out.println(u.name + ", Age: " + u.age);
	        }
	    }

}
