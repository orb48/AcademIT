package ru.academit.temperature.model;

public class Celsius {
    public double convertTo(double celsius, String secondType) {
        double result;
        switch (secondType) {
            case "Celsius":
                result = celsius;
                break;
            case "Fahrenheit":
                result = celsius * 9.0 / 5.0 + 32.0;
                break;
            case "Kelvin":
                result = celsius + 273.15;
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }
}
