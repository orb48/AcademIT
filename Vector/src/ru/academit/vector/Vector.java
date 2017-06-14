package ru.academit.vector;

public class Vector {
    private double[] coordinates;
    private int size;

    public Vector(int size) {
        if (size <= 0) throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
        for (int i = 0; i < size; ++i) {
            coordinates[i] = 0;
        }
    }

    public Vector(Vector copy) {
        for (int i = 0; i < size; ++i) {
            this.coordinates[i] = copy.coordinates[i];
        }
    }

    public Vector(double[] coordinates) {
        for (int i = 0; i < size; ++i) {
            this.coordinates[i] = coordinates[i];
        }
    }

    public Vector(int size, double[] coordinates) {
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

}
