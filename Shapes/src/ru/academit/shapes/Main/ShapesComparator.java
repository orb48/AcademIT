package ru.academit.shapes.Main;

import ru.academit.shapes.Shapes.Shapes;

import java.util.Comparator;

public class ShapesComparator implements Comparator<Shapes> {
    @Override
    public int compare(Shapes o1, Shapes o2) {
        if (o1.getPerimeter() > o2.getPerimeter()) {
            return 1;
        } else if (o1.getPerimeter() < o2.getPerimeter()) {
            return -1;
        } else {
            return 0;
        }
    }
}
