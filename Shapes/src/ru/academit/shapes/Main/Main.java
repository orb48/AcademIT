package ru.academit.shapes.Main;

import ru.academit.shapes.Shapes.*;

import java.util.Arrays;

public class Main {

    public static Shapes findShapeWithMaxArea(Shapes[] list) {
        double max = list[0].getArea();
        int indexMax = 0;
        for (int i = 1; i < list.length; ++i) {
            if (list[i].getArea() > max) {
                indexMax = i;
                max = list[i].getArea();
            }
        }
        return list[indexMax];
    }

    public static Shapes findShapesWithSecondPerimeter(Shapes[] list) {
        Arrays.sort(list, new ShapesComparator());
        return list[list.length - 2];
    }

    public static void main(String[] args) {

        Shapes[] list = new Shapes[]{new Square(3), new Square(7),
                new Triangle(2, 1, 4, 3, 5, 7), new Triangle(1, 2, 7, 3, 5, 4),
                new Rectangle(2, 5), new Rectangle(1, 3), new Circle(3), new Circle(2)};

        System.out.println("Фигура с максимальной площадью: " + findShapeWithMaxArea(list));

        System.out.println("Фигура с вторым по величине периметром: " + findShapesWithSecondPerimeter(list));
    }
}