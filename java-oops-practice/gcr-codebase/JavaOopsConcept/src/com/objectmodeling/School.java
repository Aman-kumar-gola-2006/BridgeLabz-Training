package com.objectmodeling;

import java.util.ArrayList;

public class School
{
	private String schoolName;
    private ArrayList<Student> students;

    // Constructor
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Add student to school (aggregation)
    public void addStudent(Student student) {
        students.add(student);
    }

    // Display school students
    public void displayStudents() {
        System.out.println("School: " + schoolName);
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
    public static void main(String[] args) {

        // Create School
        School school = new School("Green Valley School");

        // Create Students
        Student s1 = new Student("Aarav");
        Student s2 = new Student("Diya");

        // Create Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");
        Course c3 = new Course("Physics");

        // Add students to school (Aggregation)
        school.addStudent(s1);
        school.addStudent(s2);

        // Enroll students in courses (Association)
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c2);
        s2.enrollCourse(c3);

        // Display details
        school.displayStudents();

        s1.viewCourses();
        s2.viewCourses();

        c1.displayEnrolledStudents();
        c2.displayEnrolledStudents();
        c3.displayEnrolledStudents();
    }
}