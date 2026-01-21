package com.generics.universitycoursemanager;
import java.util.List;

/*
 * Utility class to handle courses dynamically using wildcards
 */
class CourseUtility {

    /*
     * Wildcard method to evaluate any type of course
     * ? extends CourseType allows read-only access safely
     */
    public static void evaluateAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluate();
        }
    }
}