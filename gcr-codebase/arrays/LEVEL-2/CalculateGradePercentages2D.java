// Find the percentage, grades by 2D array
import java.util.Scanner;

public class CalculateGradePercentages2D {
   public static void main(String[] args) {
       // Create a Scanner Object
      Scanner sc = new Scanner(System.in);

//taking user input for number of students
      System.out.println("enter the number of students");
      int n = sc.nextInt();


//create array for marks,percentage,grades
      int marks[][] = new int[n][3];
      int percentage[] = new int[n];
      char grades[] = new char[n];

//take the user input for marks in each subject- physics,chemistry, maths
      for (int i = 0; i < n; i++) {
         System.out.println("Enter marks in each subject - physics, chemistry , maths");
         for (int j = 0; j < 3; j++) {
            int num = sc.nextInt();
	//checking the user input if it is negative then index decremented ask user for valid input		
            if (num < 0) {
               System.out.println("Invalid marks, enter positive value");
               j--;
               continue;
            }
            marks[i][j] = num;
         }
      }


//calculating the percentageof the students
      for (int i = 0; i < n; i++) {
         int total = 0;
         for (int j = 0; j < 3; j++)
            total += marks[i][j];
         percentage[i] = total / 3;
      }

//calculating the grades 
      for (int i = 0; i < n; i++) {
         if (percentage[i] >= 80) grades[i] = 'A';
         else if (percentage[i] >= 70) grades[i] = 'B';
         else if (percentage[i] >= 60) grades[i] = 'C';
         else if (percentage[i] >= 50) grades[i] = 'D';
         else if (percentage[i] >= 40) grades[i] = 'E';
         else grades[i] = 'R';
      }

      // Display marks separately with grade level
      for (int i = 0; i < n; i++) {

         System.out.println("Student " + (i + 1));
         System.out.println("Physics   : " + marks[i][0]);
         System.out.println("Chemistry : " + marks[i][1]);
         System.out.println("Maths     : " + marks[i][2]);
         System.out.println("Percentage: " + percentage[i]);
         System.out.println("Grade     : " + grades[i]);

         if (grades[i] == 'A')
            System.out.println("level   : above agency-normalized standards");
         else if (grades[i] == 'B')
            System.out.println("level   : at agency-normalized standards");
         else if (grades[i] == 'C')
            System.out.println("level   : below, but approaching agency-normalized standards");
         else if (grades[i] == 'D')
            System.out.println("level   : well below agency-normalized standards");
         else if (grades[i] == 'E')
            System.out.println("level   : too below agency-normalized standards");
         else
            System.out.println("level   : Remedial standards");

         System.out.println();
      }

      sc.close();
   }
}