import java.util.*;
public class IntOperation {
	public static void solveExpression (){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of a " );
		int a=sc.nextInt();
		System.out.println("Enter the value of b " );
		int b=sc.nextInt();
		System.out.println("Enter the value of c " );
		int c = sc.nextInt();

		int op1 = a+(b*c);
		int op2 = (a*b)+c;
		int op3 = c+(a/b);
		int op4 = (a%b)+c;

		System.out.println("The results of Int Operations are, " + op1 + " , " + op2 + " , " + op3 + " and " + op4);
	
	}
	public static void main(String [] args){
		solveExpression();
	}
 }