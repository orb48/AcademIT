package ru.academit.shapes.Shapes;

public class Rectangle implements Shapes {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    public String toString() {
        return "Прямоугольник со сторонами " + width + ", " + height;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) width;
        hash = prime * hash + (int) height;
        return hash;
    }
}
