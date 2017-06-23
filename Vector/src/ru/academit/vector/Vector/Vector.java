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
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    public Vector(int size, double[] coordinates) {
        if (size <= 0) throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
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
    public Vector vectorsSum(Vector second) {
        if (this.getSize() > second.getSize()) {
            for (int i = 0; i < second.getSize(); ++i) {
                this.coordinates[i] += second.coordinates[i];
            }
            return this;
        }
        this.coordinates = Arrays.copyOf(this.coordinates, second.getSize());
        for (int i = 0; i < second.getSize(); ++i) {
            this.coordinates[i] += second.coordinates[i];
        }
        return this;
    }

    public static Vector vectorsSumStatic(Vector first, Vector second) {
        Vector sum = new Vector(first.getSize());
        sum.coordinates = Arrays.copyOf(first.coordinates, first.getSize());
        return sum.vectorsSum(second);
    }

    //разность векторов
    public Vector vectorsDifference(Vector second) {
        if (this.getSize() > second.getSize()) {
            for (int i = 0; i < second.getSize(); ++i) {
                this.coordinates[i] -= second.coordinates[i];
            }
            return this;
        }
        this.coordinates = Arrays.copyOf(this.coordinates, second.getSize());
        for (int i = 0; i < second.getSize(); ++i) {
            this.coordinates[i] -= second.coordinates[i];
        }
        return this;
    }

    public static Vector vectorsDifferenceStatic(Vector first, Vector second) {
        Vector difference = new Vector(first.getSize());
        difference.coordinates = Arrays.copyOf(first.coordinates, first.getSize());
        return difference.vectorsDifference(second);
    }

    //Скалярное произведение
    public static double vectorsScalarProduct(Vector first, Vector second) {
        double result = 0;
        for (int i = 0; i < Math.min(first.getSize(), second.getSize()); ++i) {
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
    public Vector expandVector() {
        return this.multiplyScalar(-1);
    }

    //Длина вектора
    public double getLengthVector() {
        double sum = 0;
        for (int i = 0; i < this.getSize(); ++i) {
            sum += Math.pow(coordinates[i], 2);
        }
        return Math.sqrt(sum);
    }

    //Получение и установка компоненты вектора по индексу
    public double getVectorComponents(int number) {
        if (number >= this.getSize()) {
            throw new IllegalArgumentException("Такой компоненты нет");
        }
        return this.coordinates[number - 1];
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        return (this.getSize() == ((Vector) o).getSize() && Arrays.equals(this.coordinates, ((Vector) o).coordinates));
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
