import java.util.*;
public class HeightAge {
	
	public static void tallest (){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Amar height");
		int Amarheight = sc.nextInt();
		System.out.println("Enter Akbar height");
		int Akbarheight = sc.nextInt();
		System.out.println("Enter Anthony height");
		int Anthonyheight = sc.nextInt();
		System.out.println("Enter Amar age");
		int Amarage = sc.nextInt();
		System.out.println("Enter Akbar age");
		int Akbarage = sc.nextInt();
		System.out.println("Enter Anthony age");
		int Anthonyage = sc.nextInt();
		
		if (Amarheight>Akbarheight && Amarheight>Anthonyheight  ){
			System.out.println("The Amar is tallest");
			
		}
		else if (Akbarheight>Amarheight && Akbarheight>Anthonyheight){
			System.out.println("The Akbar is tallest");
		}
		else{
			System.out.println("The Anthony is tallest");
		}
		
		
		
		if (Amarage<Akbarage && Amarage<Anthonyage  ){
			System.out.println("The Amar is youngest");
			
		}
		else if (Akbarage<Amarage && Akbarage<Anthonyage){
			System.out.println("The Akbar is youngest");
		}
		else{
			System.out.println("The Anthony is youngest");
		}
		
		
	}
	

	
	public static void main (String [] args){
		tallest();
		
	}
}