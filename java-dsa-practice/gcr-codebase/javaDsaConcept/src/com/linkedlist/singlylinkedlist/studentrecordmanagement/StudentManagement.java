package com.linkedlist.singlylinkedlist.studentrecordmanagement;

public class StudentManagement {

	private StudentNode head;

	public void insertAtBeginning(int rollno, String name, int age, char grade) {
		StudentNode newNode = new StudentNode(rollno, name, age, grade);
		newNode.next = head;
		head = newNode;
		System.out.println("Student register at beginning successfully.");
	}

	public void insertAtEnd(int rollno, String name, int age, char grade) {
		StudentNode newNode = new StudentNode(rollno, name, age, grade);
		if (head == null) {
         head=newNode;
         return;
         }

		StudentNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		System.out.println("Student register at end successfully");

	}

	public void insertAtPosition(int rollno, String name, int age, char grade, int pos) {
		StudentNode newNode = new StudentNode(rollno, name, age, grade);

		if (pos <= 0) {
			insertAtBeginning(rollno, name, age, grade);
			return;
		}
		StudentNode temp = head;
		for (int i = 0; i < pos-1; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Invalid position");
		}
     
		newNode.next=temp.next;
		temp.next=newNode;
		System.out.println("Student register at position successfully.");
	}

	public void delete(int rollno) {
		if(head==null)
		{
			System.out.println("No student found!!!");
		}
		
		if(head.rollno==rollno)
		{
			head=head.next;
			System.out.println("Student deleted successfully");
		}
		
		 StudentNode temp = head;
	        while (temp.next != null && temp.next.rollno != rollno) {
	            temp = temp.next;
	        }
 
	        if(temp.next==null)
	        {
	        	System.out.println("Student Not found");
	        }
	        else {
				temp.next=temp.next.next;
				System.out.println("Student deleted successfully");
			}
	        
	}
	
	public void searchByRollnumber(int rollno) {
	    StudentNode temp = head;
		while(temp!=null)
		{
			if(temp.rollno==rollno)
			{
				System.out.println(" Student found");
				displayNode(temp);
				return;
			}
			temp=temp.next;
		}
		System.out.println("Student not found");
		
	}
	 public void updateGrade(int rollNo, char newGrade) {
	        StudentNode temp = head;
	        while (temp != null) {
	            if (temp.rollno == rollNo) {
	                temp.grade = newGrade;
	                System.out.println("Grade updated successfully.");
	                return;
	            }
	            temp = temp.next;
	        }
	        System.out.println("Student not found.");
	    }
	
	public void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode temp = head;
        while (temp != null) {
            displayNode(temp);
            temp = temp.next;
        }
    }

    private void displayNode(StudentNode s) {
        System.out.println(
                "Roll No: " + s.rollno +
                ", Name: " + s.name +
                ", Age: " + s.age +
                ", Grade: " + s.grade
        );
    }
}
