package com.generics.universitycoursemanager;



/*
 * Abstract base class representing a Course Type
 * All evaluation-based courses will extend this class
 */
abstract class CourseType {

    protected String courseName;
    protected int credits;

    // Constructor to initialize common course details
    public CourseType(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    // Abstract method for evaluation details
    // Each course type will implement its own evaluation logic
    public abstract void evaluate();
}
