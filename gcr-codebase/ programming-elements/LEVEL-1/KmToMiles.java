import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        double km;
        double miles;

        Scanner input = new Scanner(System.in);
        System.out.println("welcome to Java World");
        km = input.nextInt(); 

        miles = km / 1.6;

        System.out.println(
            "The total miles is " + miles + " mile for the given " + km + " km"
        );

        input.close();
    }
}
