import java.util.Scanner;

public class BusAttendance{
public static void main(String[] args ){
	Scanner sc = new Scanner(System.in);

	System.out.println("Enter number of student");
	int n = sc.nextInt();
	sc.nextLine();

	String[] students = new String[n];

	int presentCount = 0;
	int absentCount = 0;

	//taking student names
	System.out.println("\nEnter student names :");
	for(int i=0; i<n; i++){
		System.out.println("student " + (i + 1) + " name: ");
		students[i] = sc.nextLine();
	}
	System.out.println("\n---- Attendance ----");

        // for-each loop for attendance
        for (String name : students) {
            System.out.print("Is " + name + " present? (yes/no): ");
            String status = sc.nextLine();

            if (status.equalsIgnoreCase("yes")) {
                presentCount++;
            } else {
                absentCount++;
            }
        }

        // Final result
        System.out.println("\n----- Attendance Summary -----");
        System.out.println("Total Students : " + n);
        System.out.println("Present        : " + presentCount);
        System.out.println("Absent         : " + absentCount);

        sc.close();
    }
}
