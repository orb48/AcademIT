package ru.academit.vector.Vector;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
        }
        this.coordinates = new double[size];
    }

    public Vector(Vector copy) {
        this.coordinates = Arrays.copyOf(copy.coordinates, copy.getSize());
    }

    public Vector(double[] coordinates) {
        if (coordinates.length == 0) {
            throw new IllegalArgumentException("Вектор не задан");
        }
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    public Vector(int size, double[] coordinates) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
        }
        this.coordinates = Arrays.copyOf(coordinates, size);
    }

    public int getSize() {
        return coordinates.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < getSize() - 1; ++i) {
            sb.append(coordinates[i]);
            sb.append(", ");
        }
        sb.append(coordinates[getSize() - 1]);
        sb.append("}");
        return sb.toString();
    }

    //сумма векторов
    public Vector add(Vector second) {
        if (this.getSize() < second.getSize()) {
            this.coordinates = Arrays.copyOf(this.coordinates, second.getSize());
        }
        for (int i = 0; i < second.getSize(); ++i) {
            this.coordinates[i] += second.coordinates[i];
        }
        return this;
    }

    public static Vector add(Vector first, Vector second) {
        Vector sum = new Vector(first);
        return sum.add(second);
    }

    //разность векторов
    public Vector getDifference(Vector second) {
        if (this.getSize() < second.getSize()) {
            this.coordinates = Arrays.copyOf(this.coordinates, second.getSize());
        }
        for (int i = 0; i < second.getSize(); ++i) {
            this.coordinates[i] -= second.coordinates[i];
        }
        return this;
    }

    public static Vector getDifference(Vector first, Vector second) {
        Vector difference = new Vector(first);
        return difference.getDifference(second);
    }

    //Скалярное произведение
    public static double scalarProduct(Vector first, Vector second) {
        double result = 0;
        int length = Math.min(first.getSize(), second.getSize());
        for (int i = 0; i < length; ++i) {
            result += first.coordinates[i] * second.coordinates[i];
        }
        return result;
    }

    //Умножение на скаляр
    public Vector multiplyScalar(double scalar) {
        for (int i = 0; i < this.getSize(); ++i) {
            this.coordinates[i] *= scalar;
        }
        return this;
    }

    //Разворот вектора
    public Vector expand() {
        return this.multiplyScalar(-1);
    }

    //Длина вектора
    public double getLength() {
        double sum = 0;
        for (int i = 0; i < this.getSize(); ++i) {
            sum += Math.pow(coordinates[i], 2);
        }
        return Math.sqrt(sum);
    }

    //Получение и установка компоненты вектора по индексу
    public double getComponent(int number) {
        return this.coordinates[number];
    }

    public void setComponent(int number, double newComponent) {
        this.coordinates[number] = newComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return (this.getSize() == vector.getSize() && Arrays.equals(this.coordinates, vector.coordinates));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        for (double e : this.coordinates) {
            hash = prime * hash + (int) e;
        }
        return hash;
    }
}
