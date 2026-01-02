package com.inheritance.hierarchicalinheritance.schoolsystem;

public class Main {
	public static void main(String[] args) {

        Teacher t = new Teacher("Anita", 35, "Mathematics");
        Student s = new Student("Rahul", 16, "10th");
        Staff st = new Staff("Suresh", 40, "Administration");

        t.displayBasicInfo();
        t.displayRole();
        System.out.println("--------------");

        s.displayBasicInfo();
        s.displayRole();
        System.out.println("--------------");

        st.displayBasicInfo();
        st.displayRole();
    }
}