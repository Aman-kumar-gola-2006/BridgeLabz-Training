package com.generics.universitycoursemanager;

/*
 * Assignment-based course
 */
class AssignmentCourse extends CourseType {

    private int assignmentScore;

    public AssignmentCourse(String courseName, int credits, int assignmentScore) {
        super(courseName, credits);
        this.assignmentScore = assignmentScore;
    }

    @Override
    public void evaluate() {
        System.out.println("Assignment Course: " + courseName +
                ", Credits: " + credits +
                ", Assignment Score: " + assignmentScore);
    }
}