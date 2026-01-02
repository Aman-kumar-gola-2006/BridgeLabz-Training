
package com.inheritance.multilevelinheritance.educationalcourse;

public class Main {
	 public static void main(String[] args) {

	        PaidOnlineCourse course = new PaidOnlineCourse(
	                "Java Full Stack",
	                120,
	                "Udemy",
	                true,
	                15000,
	                20
	        );

	        course.displayDetails();
	 }
}
