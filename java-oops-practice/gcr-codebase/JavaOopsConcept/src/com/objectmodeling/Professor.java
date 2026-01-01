
package com.objectmodeling;

/**
 * Professor class
 * ----------------
 * - Professor teaches courses
 * - Demonstrates ASSOCIATION with Courseuniversity
 */
public class Professor {

    private String professorName;

    // Constructor
    public Professor(String professorName) {
        this.professorName = professorName;
    }

    // Assign professor to a course
    public void assignProfessor(Courseuniversity course) {
        course.setProfessor(this);
        System.out.println(professorName + " assigned to " + course.getCourseName());
    }

    // Getter
    public String getProfessorName() {
        return professorName;
    }
}
