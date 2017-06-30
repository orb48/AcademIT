package ru.academit.matrix.Matrix;

import ru.academit.vector.Vector.Vector;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Matrix {
    private Vector[] matrixRows;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Количество уравнений или неизвестных = 0 или отрицательное число");
        }
        matrixRows = new Vector[m];
        for (int i = 0; i < m; ++i) {
            matrixRows[i] = new Vector(n);
        }
    }

    public Matrix(double[][] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].length != array[i + 1].length) {
                throw new IllegalArgumentException("Столбцы матрицы разной длины");
            }
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Количество уравнений или неизвестных = 0, отрицательное число или матрица содержит вектора разной длины");
        }
        matrixRows = new Vector[array.length];
        for (int i = 0; i < array.length; ++i) {
            matrixRows[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        for (int i = 0; i < vectors.length - 1; ++i) {
            if (vectors[i].getSize() != vectors[i + 1].getSize()) {
                throw new IllegalArgumentException("Столбцы матрицы разной длины");
            }
        }
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Количество уравнений или неизвестных = 0 или отрицательное число");
        }
        this.matrixRows = Arrays.copyOf(vectors, vectors.length);
        for (int i = 0; i < matrixRows.length; ++i) {
            this.matrixRows[i] = new Vector(vectors[i]);
        }
    }

    public Matrix(Matrix copy) {
        this.matrixRows = Arrays.copyOf(copy.matrixRows, copy.matrixRows.length);
        for (int i = 0; i < matrixRows.length; ++i) {
            this.matrixRows[i] = new Vector(copy.matrixRows[i]);
        }
    }

    public String getSize() {
        return matrixRows.length + " * " + matrixRows[0].getSize();
    }

    public Vector getRow(int index) {
        return new Vector(matrixRows[index]);
    }

    public void setRow(int index, Vector newVector) {
        if (newVector.getSize() != matrixRows[0].getSize()) {
            throw new IllegalArgumentException("Новый вектор другой длины");
        }
        matrixRows[index] = new Vector(newVector);
    }

    public Vector getColumn(int index) {
        Vector newColumn = new Vector(matrixRows.length);
        for (int i = 0; i < matrixRows.length; ++i) {
            newColumn.setComponent(i, matrixRows[i].getComponent(index));
        }
        return newColumn;
    }

    public Matrix transposeMatrix() {
        int m = this.matrixRows[0].getSize();
        Vector[] newArrayRow = new Vector[m];
        for (int i = 0; i < m; ++i) {
            newArrayRow[i] = this.getColumn(i);
        }
        this.matrixRows = newArrayRow;
        return this;
    }

    public Matrix multiplyScalar(double scalar) {
        for (Vector e : matrixRows) {
            e.multiplyScalar(scalar);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < matrixRows.length - 1; ++i) {
            sb.append(matrixRows[i].toString());
            sb.append(", ");
        }
        sb.append(matrixRows[matrixRows.length - 1]);
        sb.append("}");
        return sb.toString();
    }

}
