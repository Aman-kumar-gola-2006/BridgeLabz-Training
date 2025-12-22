import java.util.*;
public class checkAge{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Java World");
		System.out.println("Enter the age : ");
		int age  = sc.nextInt();

		if(age >=18)
		{
			System.out.println("The person age is " + age+ " and can vote ");
		}else{
			System.out.println("The person age is " + age + " and cannot vote");
		}
		sc.close();

	}
}