package ru.academit.shapes.Shapes;

import java.util.Comparator;

public interface Shapes {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    Comparator<Shapes> PerimeterComparator = new Comparator<Shapes>() {
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
    };
}
