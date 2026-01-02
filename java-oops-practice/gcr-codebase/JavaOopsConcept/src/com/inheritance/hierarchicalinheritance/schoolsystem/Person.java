package com.inheritance.hierarchicalinheritance.schoolsystem;

//Superclass
class Person {

 String name;
 int age;

 Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 void displayBasicInfo() {
     System.out.println("Name : " + name);
     System.out.println("Age  : " + age);
 }
}