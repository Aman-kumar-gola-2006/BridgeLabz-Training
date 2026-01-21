package com.generics.aidrivenresumescreeningsystem;


/*
 * Data Scientist role
 */
class DataScientist extends JobRole {

    private String specialization;

    public DataScientist(String candidateName, int experience, String specialization) {
        super(candidateName, experience);
        this.specialization = specialization;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Data Scientist Candidate: " + candidateName +
                ", Experience: " + experience + " years" +
                ", Specialization: " + specialization);
    }
}