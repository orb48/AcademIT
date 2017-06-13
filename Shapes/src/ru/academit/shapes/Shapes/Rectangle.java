package ru.academit.shapes.Shapes;

public class Rectangle implements Shapes {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getWidth() {
        return side2;
    }

    public double getHeight() {
        return side1;
    }

    public double getArea() {
        return side1 * side2;
    }

    public double getPerimeter() {
        return 2 * (side1 + side2);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return side1 == rectangle.side1 && side2 == rectangle.side2;
    }

    public String toString() {
        return "Прямоугольник со сторонами " + side1 + ", " + side2;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) side1;
        hash = prime * hash + (int) side2;
        return hash;
    }
}
