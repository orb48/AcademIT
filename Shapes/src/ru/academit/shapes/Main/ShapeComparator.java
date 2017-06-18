package ru.academit.shapes.Main;

import ru.academit.shapes.Shape.Shape;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.getPerimeter() > o2.getPerimeter()) {
            return 1;
        } else if (o1.getPerimeter() < o2.getPerimeter()) {
            return -1;
        } else {
            return 0;
        }
    }
}
