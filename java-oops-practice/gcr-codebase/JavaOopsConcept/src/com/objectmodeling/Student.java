package com.objectmodeling;
import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<Course> courses;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Enroll student in a course (association)
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // bidirectional association
    }

    // View enrolled courses
    public void viewCourses() {
        System.out.println("\nStudent: " + name);
        System.out.println("Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }

    // Getter
    public String getName() {
        return name;
    }
}