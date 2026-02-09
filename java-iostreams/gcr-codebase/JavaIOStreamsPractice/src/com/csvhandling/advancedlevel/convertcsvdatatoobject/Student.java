package com.csvhandling.advancedlevel.convertcsvdatatoobject;

class Student {
    int id;
    String name;
    int age;
    int marks;

    Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }
}