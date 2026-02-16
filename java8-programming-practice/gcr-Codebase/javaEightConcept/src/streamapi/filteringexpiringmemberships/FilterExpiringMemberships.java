package streamapi.filteringexpiringmemberships;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilterExpiringMemberships {

	public static void main(String[] args) {
		List<Membership> memberships = new ArrayList<>();

		memberships.add(new Membership(1, "Amit", LocalDate.now().plusDays(5)));
		memberships.add(new Membership(2, "Rohit", LocalDate.now().plusDays(15)));
		memberships.add(new Membership(3, "Sneha", LocalDate.now().plusDays(40)));
		memberships.add(new Membership(4, "Priya", LocalDate.now().plusDays(25)));
		memberships.add(new Membership(5, "Karan", LocalDate.now().minusDays(2)));
		memberships.add(new Membership(6, "Neha", LocalDate.now().plusDays(60)));
		memberships.add(new Membership(7, "Vikram", LocalDate.now().plusDays(10)));
		memberships.add(new Membership(8, "Anjali", LocalDate.now().plusDays(90)));
		memberships.add(new Membership(9, "Suresh", LocalDate.now().plusDays(30)));
		memberships.add(new Membership(10, "Pooja", LocalDate.now().minusDays(10)));
		
		LocalDate todayDate = LocalDate.now();
		LocalDate next30daysDate = todayDate.plusDays(30);
		memberships.stream().filter(membership -> membership.getExpiryDate().isAfter(todayDate) && membership.getExpiryDate().isBefore(next30daysDate.plusDays(1))).forEach(System.out::println); 
		
	}
}	