package com.generics.aidrivenresumescreeningsystem;

/*
 * Product Manager role
 */
class ProductManager extends JobRole {

    private String domain;

    public ProductManager(String candidateName, int experience, String domain) {
        super(candidateName, experience);
        this.domain = domain;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Product Manager Candidate: " + candidateName +
                ", Experience: " + experience + " years" +
                ", Domain: " + domain);
    }
}