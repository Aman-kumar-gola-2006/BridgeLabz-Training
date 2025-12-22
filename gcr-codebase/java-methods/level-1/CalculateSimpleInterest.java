import java.util.*;
//create a class named as simpleInterest
public class CalculateSimpleInterest
{
   //create a method to calculate simpleInterestp
	public double simpleInterest(int principle ,int rate,int time)
	{
	double SI= (principle*rate*time)/100;
	return SI ;
	}


  //main method for calling the other methods
	public static void main(String args[])
	{
	 // create a scanner object 	
	Scanner sc= new Scanner(System.in);
	
	//taking user input for principle
	System.out.println("Enter the principle");
	int principle=sc.nextInt();
	
		//taking user input for rate
	System.out.println("Enter the rate");
	int rate=sc.nextInt();
	
		//taking user input for time
	System.out.println("Enter the time");
	int time=sc.nextInt();

   //create an object of SimpleInterest class to call method
     SimpleInterest s=new SimpleInterest();
	 double si= s.simpleInterest(principle, rate,time);
   System.out.println("The Simple Interest is " +  si + "  for Principal " + principle+ " Rate of Interest " + rate + "  and Time " + time);	 
	}

}