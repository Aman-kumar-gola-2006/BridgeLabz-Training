package streamapi.transformingnamesfordisplay;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TransformNames {
	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();

		customers.add(new Customer(1, "abhay"));
		customers.add(new Customer(2, "rohit"));
		customers.add(new Customer(3, "neha"));
		customers.add(new Customer(4, "priya"));
		customers.add(new Customer(5, "karan"));
		customers.add(new Customer(6, "sneha"));
		customers.add(new Customer(7, "vikram"));
		customers.add(new Customer(8, "anjali"));
		customers.add(new Customer(9, "suresh"));
		customers.add(new Customer(10, "pooja"));
		
		
		System.out.println("Names In Sorting and Uppercase Characters : ");
		customers.stream().map(customer -> customer.getName().toUpperCase()).sorted().forEach(System.out::println);

	}
}
