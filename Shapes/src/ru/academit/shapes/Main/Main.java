package ru.academit.shapes.Main;

import ru.academit.shapes.Shape.*;

import java.util.Arrays;

public class Main {

    public static Shape findShapeWithMaxArea(Shape[] list) {
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

    public static Shape findShapesWithSecondPerimeter(Shape[] list) {
        Arrays.sort(list, new ShapeComparator());
        return list[list.length - 2];
    }

    public static void main(String[] args) {

        Shape[] list = new Shape[]{new Square(3), new Square(7),
                new Triangle(2, 1, 4, 3, 5, 7), new Triangle(1, 2, 7, 3, 5, 4),
                new Rectangle(2, 5), new Rectangle(1, 3), new Circle(3), new Circle(2)};

        System.out.println("Фигура с максимальной площадью: " + findShapeWithMaxArea(list));

        System.out.println("Фигура с вторым по величине периметром: " + findShapesWithSecondPerimeter(list));

    }
}