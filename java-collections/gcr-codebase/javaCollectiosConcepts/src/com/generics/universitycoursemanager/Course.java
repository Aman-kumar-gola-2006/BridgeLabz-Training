package com.generics.universitycoursemanager;

import java.util.ArrayList;
import java.util.List;

/*
 * Generic Course class
 * T is bounded to CourseType to ensure only valid course types are allowed
 */
class Course<T extends CourseType> {

    private List<T> courses = new ArrayList<>();

    // Method to add a course
    public void addCourse(T course) {
        courses.add(course);
    }

    // Method to get all courses
    public List<T> getCourses() {
        return courses;
    }
}
