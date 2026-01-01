package com.objectmodeling;

class Faculty {

    private int facultyId;
    private String facultyName;

    // Constructor
    public Faculty(int facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    // Display faculty details
    public void displayFaculty() {
        System.out.println("Faculty ID   : " + facultyId);
        System.out.println("Faculty Name : " + facultyName);
    }

    // Getter
    public String getFacultyName() {
        return facultyName;
    }
}