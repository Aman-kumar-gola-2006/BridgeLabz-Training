import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        double heightCm;
        double totalInches;
        int feet;
        double inches;

        Scanner input = new Scanner(System.in);

        heightCm = input.nextDouble();   

        totalInches = heightCm / 2.54;   
        feet = (int) (totalInches / 12); 
        inches = totalInches % 12;       

        System.out.println(
            "Your Height in cm is " + heightCm +
            " while in feet is " + feet +
            " and inches is " + inches
        );

        input.close();
    }
}
