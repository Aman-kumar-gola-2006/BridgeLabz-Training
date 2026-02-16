package interfaces.functionalinterface.temperaturealertsystem;

import java.util.Scanner;
import java.util.function.Predicate;

public class TemperatureAlert {
	public static void main(String[] args) {
		System.out.println("enter temperature");
		Scanner sc=new Scanner(System.in);
		double temperature=sc.nextDouble();
		
		Predicate<Double> isHigh = temperatures -> temperature>38.5;
		if (isHigh.test(temperature)) {
			System.out.println("High Temperature Alert");
		}
		else {
			System.out.println("Temperature is Normal");
		}
	}
}
