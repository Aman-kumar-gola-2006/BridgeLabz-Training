import java.util.*;
public class RocketLaunch2{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the countdown number : ");

        int counter = sc.nextInt();

        for(int i = counter; i>= 1; i--){
            System.out.println(i);

         }
        
        System.out.println("Rocket Launched!");

        sc.close();
    }
}
