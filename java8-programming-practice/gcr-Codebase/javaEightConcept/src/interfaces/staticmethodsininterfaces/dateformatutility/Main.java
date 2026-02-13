package interfaces.staticmethodsininterfaces.dateformatutility;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {

		// Gets today’s date from the system
		LocalDate today = LocalDate.now();

		// Prints the date in DD-MM-YYYY format
		System.out.println("DD-MM-YYYY: " +
				DateFormat.formatDate(today, "dd-MM-yyyy"));

		// Prints the date in YYYY/MM/DD format
		System.out.println("YYYY/MM/DD: " +
				DateFormat.formatDate(today, "yyyy/MM/dd"));
	}
}
