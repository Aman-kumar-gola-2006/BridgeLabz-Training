package com.generics.aidrivenresumescreeningsystem;


import java.util.ArrayList;
import java.util.List;

/*
 * Generic Resume class
 * T is bounded to JobRole to ensure only valid roles are processed
 */
class Resume<T extends JobRole> {

    private List<T> resumes = new ArrayList<>();

    // Add resume
    public void addResume(T resume) {
        resumes.add(resume);
    }

    // Get all resumes
    public List<T> getResumes() {
        return resumes;
    }
}