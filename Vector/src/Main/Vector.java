package Main;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;
    private int size;

    public Vector(int size) {
        this.coordinates = new double[size];
        if (size <= 0) throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
        for (int i = 0; i < size; ++i) {
            coordinates[i] = 0;
        }
    }

    public Vector(Vector copy) {
        this.coordinates = new double[copy.getSize()];
        for (int i = 0; i < copy.getSize(); ++i) {
            this.coordinates[i] = copy.coordinates[i];
        }
    }

    public Vector(double[] coordinates) {
        this.coordinates = new double[coordinates.length];
        for (int i = 0; i < coordinates.length; ++i) {
            this.coordinates[i] = coordinates[i];
        }
    }

    public Vector(int size, double[] coordinates) {
        this.coordinates = new double[size];
        if (size <= 0) throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
        for (int i = 0; i < coordinates.length; ++i) {
            this.coordinates[i] = coordinates[i];
        }
        if (coordinates.length < size) {
            for (int i = coordinates.length; i < size; i++) {
                this.coordinates[i] = 0;
            }
        }
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
            Vector vectorSum = new Vector(this);
            for (int i = 0; i < second.getSize(); ++i) {
                vectorSum.coordinates[i] += second.coordinates[i];
            }
            return vectorSum;
        }
        Vector vectorSum = new Vector(second);
        for (int i = 0; i < this.getSize(); ++i) {
            vectorSum.coordinates[i] += this.coordinates[i];
        }
        return vectorSum;
    }

    public static double[] vectorsSum(double[] first, double[] second) {
        if (first.length > second.length) {
            double[] resultSum = Arrays.copyOf(first, first.length);
            for (int i = 0; i < second.length; ++i) {
                resultSum[i] += second[i];
            }
            return resultSum;
        }
        double[] resultSum = Arrays.copyOf(second, second.length);
        for (int i = 0; i < first.length; ++i) {
            resultSum[i] += first[i];
        }
        return resultSum;
    }
}
