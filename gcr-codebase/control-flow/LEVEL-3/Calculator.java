
import java.util.*;

	public class Calculator{

	public static void calculator(int n1, int n2, String op)
	{
	  switch(op)
	  {
	    case "+" :
		System.out.println(n1+n2);
		break;
		case "-" :
		System.out.println(n1-n2);
		break;
		case "*" :
		System.out.println(n1*n2);
		break;
		case "/" :
		System.out.println(n1/n2);
		break;
		default :
		System.out.println("Invalid operations");
		
	  }
	}
	public static void main(String args[])
	{
	   Scanner sc=new Scanner(System.in);
		System.out.println("welcome to Java World");
	   System.out.println(" Enter first number ");
	   int first=sc.nextInt();
	   
	   System.out.println(" Enter number ");
	   int second=sc.nextInt();

	   System.out.println(" Enter the operations like- +, -, *, / ");
       String op=sc.next();
	   
	   calculator(first,second, op);

	   
	   
	}

	}
