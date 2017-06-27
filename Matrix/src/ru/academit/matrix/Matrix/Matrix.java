package ru.academit.matrix.Matrix;

import ru.academit.vector.Vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Количество уравнений или неизвестных = 0 или отрицательное число");
        }
        vectors = new Vector[m];
        for (int i = 0; i < m; ++i) {
            vectors[i] = new Vector(n);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Количество уравнений или неизвестных = 0 или отрицательное число");
        }
        vectors = new Vector[array.length];
        for (int i = 0; i < array.length; ++i) {
            vectors[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Количество уравнений или неизвестных = 0 или отрицательное число");
        }
        this.vectors = Arrays.copyOf(vectors, vectors.length);
    }

    public Matrix(Matrix copy) {
        this.vectors = Arrays.copyOf(copy.vectors, copy.vectors.length);
    }

    public String getSize() {
        return vectors.length + " * " + vectors[0].getSize();
    }

    public Vector getVectorString(int index) {
        return vectors[index];
    }

    public void setVectorString(int index, Vector newVector) {
        vectors[index] = new Vector(newVector);
    }

    public Vector getVectorColumn(int index) {
        Vector newVectorColumn = new Vector(vectors.length);
        for (int i = 0; i < vectors.length; ++i) {
            newVectorColumn.setComponent(i, vectors[i].getComponent(index));
        }
        return newVectorColumn;
    }

    public Matrix transposeMatrix() {
        int n = this.vectors.length;
        int m = this.vectors[0].getSize();
        Matrix transposeMatrix = new Matrix(n, m);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == j) {
                    transposeMatrix.vectors[i].setComponent(i, this.vectors[i].getComponent(i));
                } else {
                    transposeMatrix.vectors[j].setComponent(i, this.vectors[i].getComponent(j));
                }
            }
        }
        return transposeMatrix;
    }

    public Matrix multiplyScalar(double scalar) {
        int m = this.vectors.length;
        for (int i = 0; i < m; ++i) {
            vectors[i].multiplyScalar(scalar);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < vectors.length - 1; ++i) {
            sb.append(vectors[i].toString());
            sb.append(", ");
        }
        sb.append(vectors[vectors.length - 1]);
        sb.append("}");
        return sb.toString();
    }

}
