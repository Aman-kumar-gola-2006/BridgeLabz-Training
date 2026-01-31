package com.setinterface.insurancepolicymanagement;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		 PolicyManager manager = new PolicyManager();

	        Policy p1 = new Policy("P1", "Asha",
	                LocalDate.now().plusDays(10), "Health", 5000);

	        Policy p2 = new Policy("P2", "Rahul",
	                LocalDate.now().plusDays(40), "Auto", 3000);

	        Policy p3 = new Policy("P3", "Neha",
	                LocalDate.now().plusDays(20), "Home", 7000);

	        Policy p4 = new Policy("P1", "Asha",
	                LocalDate.now().plusDays(10), "Health", 5000); // duplicate

	        manager.addPolicy(p1);
	        manager.addPolicy(p2);
	        manager.addPolicy(p3);
	        manager.addPolicy(p4);

	        System.out.println("\nAll Policies:");
	        manager.showAllPolicies();

	        System.out.println("\nExpiring Soon:");
	        manager.expiringSoon();

	        System.out.println("\nHealth Policies:");
	        manager.byCoverage("Health");
	    }
}
