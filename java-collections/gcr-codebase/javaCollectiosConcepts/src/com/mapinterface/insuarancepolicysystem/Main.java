package com.mapinterface.insuarancepolicysystem;

import java.time.LocalDate;
public class Main {


	    public static void main(String[] args) {

	        PolicyManager manager = new PolicyManager();

	        // Create policies
	        Policy p1 = new Policy("P101", "Alice",
	                LocalDate.now().plusDays(10), "Health", 5000);

	        Policy p2 = new Policy("P102", "Bob",
	                LocalDate.now().plusDays(40), "Auto", 3000);

	        Policy p3 = new Policy("P103", "Alice",
	                LocalDate.now().minusDays(5), "Home", 7000);

	        // Add policies
	        manager.addPolicy(p1);
	        manager.addPolicy(p2);
	        manager.addPolicy(p3);

	        System.out.println(" Policy P101:");
	        System.out.println(manager.getPolicyByNumber("P101"));

	        System.out.println("\n Policies Expiring Soon:");
	        manager.policiesExpiringSoon();

	        System.out.println("\n Policies for Alice:");
	        manager.policiesByHolder("Alice");

	        System.out.println("\nRemoving expired policies...");
	        manager.removeExpiredPolicies();
	    }
	

}
