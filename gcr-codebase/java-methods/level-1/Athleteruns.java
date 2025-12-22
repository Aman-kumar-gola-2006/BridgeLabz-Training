import java.util.*;
//create a class named as Athleteruns
public class Athleteruns
{
   //create a method to calculate simpleInterestp
	public int perimeter(int side1 ,int side2,int side3)
	{
	   int perimeters=side1+side2+side3;
	   int round=perimeters/5;
	   return round;
	}


  //main method for calling the other methods
	public static void main(String args[])
	{
	 // create a scanner object 	
	Scanner sc= new Scanner(System.in);
		System.out.println("welcome to Java World");
	
	//taking user input for side1
	System.out.println("Enter the side1");
	int side1=sc.nextInt();
	
		//taking user input for side2
	System.out.println("Enter the side2");
	int side2=sc.nextInt();
	
		//taking user input for side3
	System.out.println("Enter the side3");
	int side3=sc.nextInt();

   //create an object of SimpleInterest class to call method
     Athleteruns s = new Athleteruns();
	 int round= s.perimeter(side1, side2,side3);
     System.out.println(" Rounds = " + round);	 
	}

}