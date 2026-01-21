package com.generics.aidrivenresumescreeningsystem;

/*
 * Abstract base class representing a Job Role
 * All specific roles will extend this class
 */
abstract class JobRole {

    protected String candidateName;
    protected int experience; // years of experience

    // Constructor
    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    // Abstract method to evaluate resume
    public abstract void evaluateResume();
}