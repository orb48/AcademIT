package ru.academit.temperature.controller;

import ru.academit.temperature.model.Celsius;
import ru.academit.temperature.model.Fahrenheit;
import ru.academit.temperature.model.Kelvin;

public class Controller {

    public double calculate(double enteredTemperature, String firstType, String secondType) {
        double result = -1;
        switch (firstType) {
            case "Celsius":
                Celsius celsius = new Celsius();
                result = celsius.convertTo(enteredTemperature, secondType);
                break;
            case "Fahrenheit":
                Fahrenheit fahrenheit = new Fahrenheit();
                result = fahrenheit.convertTo(enteredTemperature, secondType);
                break;
            case "Kelvin":
                Kelvin kelvin = new Kelvin();
                result = kelvin.convertTo(enteredTemperature, secondType);
                break;
            default:
                break;
        }
        return result;
    }
}
