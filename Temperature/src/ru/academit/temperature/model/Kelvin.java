package ru.academit.temperature.model;

public class Kelvin {
    public double convertTo(double kelvin, String secondType) {
        double result;
        switch (secondType) {
            case "Celsius":
                result = kelvin - 273.15;
                break;
            case "Fahrenheit":
                result = (kelvin - 273.15) * 9.0 / 5.0 + 32.0;
                break;
            case "Kelvin":
                result = kelvin;
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }
}
