package ru.academit.temperature.model;

public class Fahrenheit {
    public double convertTo(double fahrenheit, String secondType) {
        double result;
        switch (secondType) {
            case "Celsius":
                result = (fahrenheit - 32.0) * 5.0 / 9.0;
                break;
            case "Fahrenheit":
                result = fahrenheit;
                break;
            case "Kelvin":
                result = (fahrenheit - 32.0) * 5.0 / 9.0 + 273.15;
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }
}
