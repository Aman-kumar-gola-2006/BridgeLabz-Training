import java.util.*;
public class Distance {

public static void distance(int a)
{
  int yard=a/3;
  double miles = (double) a / 5280;

 System.out.println(" The distance in yards is  " + yard + "  while the distance in miles is " + miles);
}

public static void main(String args[])
{
  Scanner sc = new Scanner(System.in);
  System.out.println("welcome to Java World");
  System.out.println("Enter the distance in Feet ");
  int distanceinfeet = sc.nextInt();
  distance(distanceinfeet);
}

}