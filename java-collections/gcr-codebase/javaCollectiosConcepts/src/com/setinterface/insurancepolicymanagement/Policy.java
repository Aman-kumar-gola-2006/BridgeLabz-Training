package com.setinterface.insurancepolicymanagement;

import java.time.LocalDate;
import java.util.Objects;

public class Policy {
	String policyNumber;
	String holderName;
	LocalDate expiryDate;
	String coverageType;
	double premium;
	
	public Policy(String policyNumber, String holderName, LocalDate expirtDate, String coverageType, double premium) {
		this.policyNumber=policyNumber;
		this.holderName=holderName;
		this.expiryDate=expirtDate;
		this.coverageType=coverageType;
		this.premium=premium;
	}
	
	@Override
	public boolean equals(Object obj) {
		Policy p = (Policy) obj;
		return this.policyNumber.equals(p.policyNumber);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(policyNumber);
	}
	
	@Override
	public String toString() {
		  return policyNumber + " | " + holderName + " | " +
	               expiryDate + " | " + coverageType + " | " + premium;
	}
	
}
