// Find the percentage, grades
import java.util.Scanner;

public class CalculateGradePercentages {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner sc = new Scanner(System.in);
	  
	  //take input of number from user
	  System.out.println("enter the number of students");
	  int n=sc.nextInt();     
	  
	  //create an array marks of size number equal to students
	  int marks[]=new int[n];
	  
	  //create an array percentage of size number equal to students
	  int percentage[]=new int[n];
	  
	  //create an array grades of size number equal to students
	  char grades[]=new char[n];
	  
	  //take input of marks from user
	  //And calculate the percentage for each students
	  for(int i=0;i<n;i++)
	  {
		  System.out.println("Enter marks in each subject - physics, chemistry , maths"); 
	      for(int j=0;j<3;j++)
		  {	 
			 int num=sc.nextInt();  

             if(num < 0){
                System.out.println("Invalid marks, enter positive value");
                j--;
                continue;
             }

		     marks[i]+= num;
		  }
		 percentage[i]=marks[i]/3;
	  }
	  
	 //Calculate the grades for the percentage 
	  for(int i=0;i<n;i++)
	  {
		  if(percentage[i]>=80)
		  {
			  grades[i]='A';
		  }
		 else if(percentage[i]>=70 && percentage[i]<=79)
		  {
			  grades[i]='B';
		  }
		 else if(percentage[i]>=60 && percentage[i]<=69)
		  {
			  grades[i]='C';
		  }
		  else if(percentage[i]>=50 && percentage[i]<=59)
		  {
			  grades[i]='D';
		  }
		  else if(percentage[i]>=40 && percentage[i]<=49)
		  {
			  grades[i]='E';
		  }
		  else
		  {
			  grades[i]='R';
		  } 
	  }
	  
	  //finally display the marks , percentage, grades and comments 
	  for(int i=0;i<n;i++)
	  {
		  if(grades[i]=='A')
		  {
			  System.out.println("Marks - " + marks[i] + " Percentage - " + percentage[i] + " Grade - " + grades[i] + " - above agency-normalized standards");
		  } 
		  if(grades[i]=='B')
		  {
			  System.out.println("Marks - " + marks[i] + " Percentage - " + percentage[i] + " Grade - " + grades[i] + " - at agency-normalized standards");
		  }
		  if(grades[i]=='C')
		  {
			  System.out.println("Marks - " + marks[i] + " Percentage - " + percentage[i] + " Grade - " + grades[i] + " - below, but approaching agency-normalized standards");
		  }
		  if(grades[i]=='D')
		  {
			  System.out.println("Marks - " + marks[i] + " Percentage - " + percentage[i] + " Grade - " + grades[i] + "- well below, agency-normalized standards");
		  }
		  if(grades[i]=='E')
		  {
			  System.out.println("Marks - " + marks[i] + " Percentage - " + percentage[i] + " Grade - " + grades[i] + " - too below, agency-normalized standards");
		  }
		  if(grades[i]=='R')
		  {
			  System.out.println("Marks - " + marks[i] + " Percentage - " + percentage[i] + " Grade - " + grades[i] + "  - Remedial standards");
		  }
	  }
	
      // Close the Scanner Object
      sc.close();
   }
}