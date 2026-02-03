package com.junit.advancedjunitpractice.temperatureconvertor;

import static org.junit.Assert.*;
import org.junit.Test;

// JUnit 4 test class for TemperatureConverter
public class TemperatureConverterTest {

	TemperatureConverter converter = new TemperatureConverter();

	@Test
	public void testCelsiusToFahrenheit() {
		// 0°C = 32°F
		assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.01);
	}

	@Test
	public void testFahrenheitToCelsius() {
		// 32°F = 0°C
		assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.01);
	}

	@Test
	public void testBodyTemperatureConversion() {
		// 37°C ≈ 98.6°F
		assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.1);
	}
}
