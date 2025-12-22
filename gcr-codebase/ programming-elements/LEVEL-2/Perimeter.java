import java.util.*;
public class Perimeter{
	public static void calculatePerimeter(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the side of the square ");
		int side = sc.nextInt();
		int perimeter = 4*side;
		System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
	
	}
	public static void main(String [] args){
		calculatePerimeter();
	}
 }