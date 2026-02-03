package com.junit.advancedjunitpractice.dateformatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Formats date from yyyy-MM-dd to dd-MM-yyyy
public class DateFormatter {

    public String formatDate(String inputDate) {
        // Parse input date
        LocalDate date = LocalDate.parse(inputDate);

        // Format to required pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}
