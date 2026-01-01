package com.objectmodeling;

import java.util.ArrayList;
public class Studentuniversity {

    private String studentName;
    private ArrayList<Courseuniversity> courses;

    // Constructor
    public Studentuniversity(String studentName) {
        this.studentName = studentName;
        this.courses = new ArrayList<>();
    }

    /**
     * Student enrolls in a course
     * Demonstrates communication between objects
     */
    public void enrollCourse(Courseuniversity course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(studentName + " enrolled in " + course.getCourseName());
    }

    // Getter
    public String getStudentName() {
        return studentName;
    }

    /**
     * Main method
     * -----------
     * Demonstrates student–course–professor interaction
     */
    public static void main(String[] args) {

        // Create students
        Studentuniversity s1 = new Studentuniversity("Rahul");
        Studentuniversity s2 = new Studentuniversity("Anita");

        // Create professor
        Professor professor = new Professor("Dr. Verma");

        // Create course
        Courseuniversity course = new Courseuniversity("Java Programming");

        // Assign professor to course
        professor.assignProfessor(course);

        // Enroll students in course
        s1.enrollCourse(course);
        s2.enrollCourse(course);

        // Display course details
        course.displayCourseDetails();
    }
}