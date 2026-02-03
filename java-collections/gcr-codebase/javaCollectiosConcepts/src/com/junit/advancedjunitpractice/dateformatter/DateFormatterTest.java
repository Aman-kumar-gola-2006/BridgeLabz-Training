package com.junit.advancedjunitpractice.dateformatter;

import static org.junit.Assert.*;
import org.junit.Test;

// JUnit 4 test class for DateFormatter
public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    public void testValidDateFormat() {
       assertEquals("25-01-2026", formatter.formatDate("2026-01-25"));
    }

    @Test(expected = Exception.class)
    public void testInvalidDateFormat() {
        // Invalid format should throw exception
        formatter.formatDate("25-01-2026");
    }
}
