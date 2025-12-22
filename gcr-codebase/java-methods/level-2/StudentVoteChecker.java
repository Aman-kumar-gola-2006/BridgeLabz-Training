import java.util.*;

  public class StudentVoteChecker{
  
	   public static  boolean canStudentVote(int age)
	   {
     // Validate the user input number, if negative state return false, greater than or equal to 18 return true  

	     if(age<0)
		{
		  return false; 
		}
		else if(age>=18)
		{
            return true;
		}
		else{      
           return false; 
        }
	   }
	   
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner sc = new Scanner(System.in);
	   System.out.println("welcome to Java World");

     //declaring an array of size 10
     int age[]=new int[10];
	 
      // Take input for a students age by using for loop
      System.out.print("Enter the age of students: ");
     for(int i=0;i<age.length;i++){
	    age[i]=sc.nextInt();
		if(canStudentVote(age[i]))
		{
	    System.out.println(" Student with age " + age[i] + " can vote ");	
		}
		else
	  System.out.println(" Student with age " + age[i] + " can not vote ");	
	   }
   }

}
     
     