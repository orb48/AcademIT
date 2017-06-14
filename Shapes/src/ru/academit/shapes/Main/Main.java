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
        Arrays.sort(list, Shapes.PerimeterComparator);
        return list[list.length - 2];
    }

    public static void main(String[] args) {

        final int COUNT_SHAPES = 8;

        Shapes[] list = new Shapes[COUNT_SHAPES];

        list[0] = new Square(3);
        list[1] = new Square(7);
        list[2] = new Triangle(2, 1, 4, 3, 5, 7);
        list[3] = new Triangle(1, 2, 7, 3, 5, 4);
        list[4] = new Rectangle(2, 5);
        list[5] = new Rectangle(1, 3);
        list[6] = new Circle(3);
        list[7] = new Circle(2);

        System.out.println("Фигура с максимальной площадью: " + findShapeWithMaxArea(list));

        System.out.println("Фигура с вторым по величине периметром: " + findShapesWithSecondPerimeter(list));
    }
}