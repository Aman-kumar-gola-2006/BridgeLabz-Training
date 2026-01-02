package com.inheritance.multilevelinheritance.educationalcourse;

//Subclass extending OnlineCourse
class PaidOnlineCourse extends OnlineCourse {

 double fee;
 double discount; // in percentage

 // Constructor
 PaidOnlineCourse(String courseName, int duration, String platform,
                  boolean isRecorded, double fee, double discount) {
     super(courseName, duration, platform, isRecorded);
     this.fee = fee;
     this.discount = discount;
 }

 @Override
 void displayDetails() {
     super.displayDetails();
     System.out.println("Course Fee  : ₹" + fee);
     System.out.println("Discount   : " + discount + "%");
     System.out.println("Final Fee  : ₹" + (fee - (fee * discount / 100)));
 }
}