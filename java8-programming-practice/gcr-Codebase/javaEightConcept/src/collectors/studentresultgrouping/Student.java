package collectors.studentresultgrouping;

public class Student {

	String name;
	char grade;
	
	public Student(String name,char grade) {
		// TODO Auto-generated constructor stub
		this.grade=grade;
		this.name=name;
	}
	
	String getName()
	{
		return name;
	}
	char getGrade() {
		return grade;
	}
	
	@Override
    public String toString() 
	{
		return "Student Name : " + name + " | Grade : " + grade;
	}
	
}