package com.generics.aidrivenresumescreeningsystem;

import java.util.ArrayList;
import java.util.List;

/*
 * Utility class containing generic and wildcard methods
 */
class ResumeScreeningUtil {

    /*
     * Generic method to screen a single resume
     * Works for any JobRole type
     */
    public static <T extends JobRole> void screenResume(T resume) {
        System.out.println("AI Screening in progress...");
        resume.evaluateResume();
    }

    /*
     * Wildcard method to screen multiple resumes dynamically
     * Can accept resumes of any JobRole type
     */
    public static void screenAllResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.evaluateResume();
        }
    }
}