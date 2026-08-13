package in.sp.beans;

public class Student
{
	private String name;
	private int rollno;
	private String emailid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

    public void display()
	{
		System.out.println("Name : "+name);
		System.out.println("Roll No : "+rollno);
		System.out.println("Email Id : "+emailid);
	}
}