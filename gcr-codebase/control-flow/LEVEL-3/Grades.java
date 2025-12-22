import java.util.*;

	public class Grades{

	public static void grades(int physics, int chemistry, int maths)
			 System.out.println("welcome to Java World");
	{
	  int percentage=(physics+chemistry+maths)/3;
	  if(percentage>=80)
	  {
	    System.out.println(percentage + " - Grade A - above agency-normalized standards");
	  }
	 else if(percentage>=70 && percentage<=70)
	  {
	    System.out.println(percentage + "- Grade B - at agency-normalized standards");
	  }
	  else if(percentage<=69 && percentage>=60)
	  {
	    System.out.println(percentage + " - Grade C - below, but approaching agency-normalized standards");
	  }
	   else if(percentage<=59 && percentage>=50)
	  {
	    System.out.println(percentage + " - Grade  D - well below, agency-normalized standards");
	  }
	   else if(percentage<=49 && percentage>=40)
	  {
	    System.out.println(percentage + " - Grade E - too below, agency-normalized standards");
	  }
	   else 
	  {
	    System.out.println(percentage + " Grade R - Remedial standards");
	  }
	}
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in); 
	   System.out.println("Enter marks");
	   int physics=sc.nextInt();
	   	   int chemistry=sc.nextInt();
		   	   int maths=sc.nextInt();
	   
	   grades(physics,chemistry,maths);

	   
	   
	}

	}