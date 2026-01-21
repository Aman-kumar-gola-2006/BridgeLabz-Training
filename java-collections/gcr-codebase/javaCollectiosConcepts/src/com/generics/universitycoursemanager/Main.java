package com.generics.universitycoursemanager;

/*
 * Main class to test the University Course Management System
 */
public class Main {

	
	public static void main(String[] args) {

        // Creating course managers for different course types
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        // Adding exam-based courses
        examCourses.addCourse(new ExamCourse("Data Structures", 4, 85));
        examCourses.addCourse(new ExamCourse("Operating Systems", 3, 78));

        // Adding assignment-based courses
        assignmentCourses.addCourse(new AssignmentCourse("Software Engineering", 4, 90));
        assignmentCourses.addCourse(new AssignmentCourse("Web Development", 3, 88));

        // Adding research-based courses
        researchCourses.addCourse(new ResearchCourse("AI Research", 5, "Machine Learning"));
        researchCourses.addCourse(new ResearchCourse("Cyber Security Research", 5, "Network Security"));

        // Evaluating all courses using wildcard method
        System.out.println("---- Exam Based Courses ----");
        CourseUtility.evaluateAllCourses(examCourses.getCourses());

        System.out.println("\n---- Assignment Based Courses ----");
        CourseUtility.evaluateAllCourses(assignmentCourses.getCourses());

        System.out.println("\n---- Research Based Courses ----");
        CourseUtility.evaluateAllCourses(researchCourses.getCourses());
    }

}
