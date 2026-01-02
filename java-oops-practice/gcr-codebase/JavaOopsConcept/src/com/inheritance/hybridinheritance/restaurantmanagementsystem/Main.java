
package com.inheritance.hybridinheritance.restaurantmanagementsystem;

public class Main {
	  public static void main(String[] args) {

	        // -------- Restaurant Management System --------
	        Worker chef = new Chef("Rahul", 101);
	        Worker waiter = new Waiter("Amit", 102);

	        chef.performDuties();
	        waiter.performDuties();

	        
}
}
