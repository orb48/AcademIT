package ru_academit_range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1.7, 3.5);
        double lengthRange = range.calcLength();
        System.out.println("Длина промежутка = " + lengthRange);
        System.out.println(range.isInside(1.9));
    }
}

