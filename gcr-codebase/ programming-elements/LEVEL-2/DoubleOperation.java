import java.util.*;
public class DoubleOperation {
	public static void solveExpression (){
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
		System.out.println("Enter the value of a " );
		double a=sc.nextDouble();
		System.out.println("Enter the value of b " );
		double b=sc.nextDouble();
		System.out.println("Enter the value of c " );
		double c = sc.nextDouble();

		double op1 = a+(b*c);
		double op2 = (a*b)+c;
		double op3 = c+(a/b);
		double op4 = (a%b)+c;

		System.out.println("The results of Int Operations are, " + op1 + " , " + op2 + " , " + op3 + " and " + op4);
	
	}
	public static void main(String [] args){
		solveExpression();
	}
 }