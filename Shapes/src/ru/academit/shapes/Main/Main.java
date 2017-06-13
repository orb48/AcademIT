package ru.academit.shapes.Main;

import ru.academit.shapes.Shapes.*;

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
        double max1 = list[0].getPerimeter();
        double max2 = list[1].getPerimeter();
        int indexMax1 = 0;
        int indexMax2 = 1;
        for (int i = 1; i < list.length; ++i) {
            double perimeter = list[i].getPerimeter();
            if (perimeter > max1) {
                max2 = max1;
                max1 = perimeter;
                indexMax2 = indexMax1;
                indexMax1 = i;
            } else if (perimeter > max2) {
                max2 = perimeter;
                indexMax2 = i;
            }
        }
        return list[indexMax2];
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