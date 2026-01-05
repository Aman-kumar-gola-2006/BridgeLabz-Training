package com.linkedlist.singlylinkedlist.studentrecordmanagement;

public class StudentNode {

	int rollno;
	String name;
	int age;
	char grade;
	StudentNode next;

	public StudentNode(int rollno, String name, int age, char grade) {
		this.age = age;
		this.grade = grade;
		this.rollno = rollno;
		this.name = name;
		this.next = null;
	}
}
