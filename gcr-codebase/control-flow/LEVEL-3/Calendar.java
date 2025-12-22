import java.util.*;

public class Calendar {

    public static void calendar(int m, int d, int y) {

        int y1 = y - (14 - m) / 12;
        int x = y1 + (y1 / 4) - (y1 / 100) + (y1 / 400);
        int m1 = m + 12 * ((14 - m) / 12) - 2;

        int day = (d + x + (31 * m1) / 12) % 7; 

        days(day);
    }

    public static void days(int d) {
        switch (d) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid");
        }
    }

    public static void main(String args[]) {
        System.out.println("welcome to Java World");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Month (Jan=1, Feb=2, ...):");
        int month = sc.nextInt();

        System.out.println("Enter Date (1 – 31):");
        int date = sc.nextInt();

        System.out.println("Enter Year :");
        int year = sc.nextInt();

        calendar(month, date, year);
    }
}