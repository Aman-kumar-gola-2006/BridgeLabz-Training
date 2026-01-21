package com.generics.aidrivenresumescreeningsystem;

/*
 * Software Engineer role
 */
class SoftwareEngineer extends JobRole {

    private String programmingLanguage;

    public SoftwareEngineer(String candidateName, int experience, String programmingLanguage) {
        super(candidateName, experience);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Software Engineer Candidate: " + candidateName +
                ", Experience: " + experience + " years" +
                ", Language: " + programmingLanguage);
    }
}