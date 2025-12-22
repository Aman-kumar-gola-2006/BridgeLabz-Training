
import java.util.*;
public class QuotientReminder {

public static void calculate(int a, int b)
{
  int quotient=a/b;
  int reminder=a%b;
 
System.out.println(" The Quotient is " +  quotient+ " and Reminder is   " + reminder  + " of two numbers " + a + "  and " + b);
  
  
}


public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the first number ");
  int number1=sc.nextInt();
  System.out.println("Enter the second number ");
  int number2=sc.nextInt();
  calculate(number1,number2); 
}

}
