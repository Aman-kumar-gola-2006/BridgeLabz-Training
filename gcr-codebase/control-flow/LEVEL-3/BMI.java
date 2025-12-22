import java.util.*;
public class BMI {
	
	public static void findBmi(){
		Scanner sc = new Scanner(System.in);
		double weight = sc.nextDouble();
		double height = sc.nextDouble();
		height*=0.01;
		
		double bmi = weight / (height*height);
		
		if (bmi <= 18.4){
			System.out.println("Underweight");
		}
		else if (bmi >= 18.5 && bmi <=24.9){
			System.out.println("Normal");
		}
		else if (bmi >= 25.0 && bmi <=39.9){
			System.out.println("Overweight");
		}
		else if (bmi >= 40){
			System.out.println("Obese");
		}
		else {
			System.out.println("Invalid input");
		}
		
	}
	
	public static void main (String [] args){
		findBmi();
		
	}
}