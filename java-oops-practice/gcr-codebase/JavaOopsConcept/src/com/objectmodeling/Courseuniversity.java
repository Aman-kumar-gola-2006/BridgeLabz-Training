package com.objectmodeling;

import java.util.ArrayList;

public class Courseuniversity {

    private String courseName;
    private Professor professor;
    private ArrayList<Studentuniversity> students;

    // Constructor
    public Courseuniversity(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Add student to course
    public void addStudent(Studentuniversity student) {
        students.add(student);
    }

    // Assign professor
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    // Getter
    public String getCourseName() {
        return courseName;
    }

    // Display full course details
    public void displayCourseDetails() {
        System.out.println("\nCourse Name : " + courseName);
        System.out.println("Professor  : " + professor.getProfessorName());
        System.out.println("Students Enrolled:");
        for (Studentuniversity student : students) {
            System.out.println("- " + student.getStudentName());
        }
    }
}