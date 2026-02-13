package interfaces.staticmethodsininterfaces.dateformatutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateFormat {
	 static String formatDate(LocalDate date, String pattern) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	        return date.format(formatter);
	    }
}
