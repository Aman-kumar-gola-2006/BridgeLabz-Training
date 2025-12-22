import java.util.*;
class SimpleInterest {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        System.out.println("welcome to Java World");
        
        double p = kb.nextDouble();
        double r = kb.nextDouble();
        double t = kb.nextDouble();
        System.out.println("SI for Principal Amount is : " + (p*r*t)/100);
    }
}