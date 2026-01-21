package com.generics.aidrivenresumescreeningsystem;

public class Main {

    public static void main(String[] args) {

        // Creating resume processors for different job roles
        Resume<SoftwareEngineer> softwareEngineers = new Resume<>();
        Resume<DataScientist> dataScientists = new Resume<>();
        Resume<ProductManager> productManagers = new Resume<>();

        // Adding resumes
        softwareEngineers.addResume(
                new SoftwareEngineer("Amit", 3, "Java"));
        softwareEngineers.addResume(
                new SoftwareEngineer("Neha", 5, "Python"));

        dataScientists.addResume(
                new DataScientist("Rahul", 4, "Machine Learning"));

        productManagers.addResume(
                new ProductManager("Sneha", 6, "E-Commerce"));

        // Screening single resume using generic method
        System.out.println("---- Single Resume Screening ----");
        ResumeScreeningUtil.screenResume(
                softwareEngineers.getResumes().get(0));

        // Screening all resumes using wildcard method
        System.out.println("\n---- Software Engineer Resumes ----");
        ResumeScreeningUtil.screenAllResumes(
                softwareEngineers.getResumes());

        System.out.println("\n---- Data Scientist Resumes ----");
        ResumeScreeningUtil.screenAllResumes(
                dataScientists.getResumes());

        System.out.println("\n---- Product Manager Resumes ----");
        ResumeScreeningUtil.screenAllResumes(
                productManagers.getResumes());
    }
}