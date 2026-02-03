package com.junit.advancedjunitpractice.temperatureconvertor;

//Converts temperature between Celsius and Fahrenheit
public class TemperatureConverter {

// Converts Celsius to Fahrenheit
public double celsiusToFahrenheit(double celsius) {
   return (celsius * 9 / 5) + 32;
}

// Converts Fahrenheit to Celsius
public double fahrenheitToCelsius(double fahrenheit) {
   return (fahrenheit - 32) * 5 / 9;
}
}
