package com.generics.universitycoursemanager;

/*
 * Research-based course
 */
class ResearchCourse extends CourseType {

    private String researchTopic;

    public ResearchCourse(String courseName, int credits, String researchTopic) {
        super(courseName, credits);
        this.researchTopic = researchTopic;
    }

    @Override
    public void evaluate() {
        System.out.println("Research Course: " + courseName +
                ", Credits: " + credits +
                ", Research Topic: " + researchTopic);
    }
}