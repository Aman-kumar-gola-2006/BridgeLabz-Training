package com.objectmodeling;
import java.util.ArrayList;

public class Course {
	private String courseName;
    private ArrayList<Student> enrolledStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Add student to course
    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Display students enrolled in this course
    public void displayEnrolledStudents() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
       

}
    public String getCourseName() {
        return courseName;
    }
    }