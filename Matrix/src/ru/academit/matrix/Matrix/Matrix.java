package ru.academit.matrix.Matrix;

import com.sun.xml.internal.bind.v2.TODO;
import ru.academit.vector.Vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Количество уравнений или неизвестных = 0 или отрицательное число");
        }
        rows = new Vector[m];
        for (int i = 0; i < m; ++i) {
            rows[i] = new Vector(n);
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
        rows = new Vector[array.length];
        for (int i = 0; i < array.length; ++i) {
            rows[i] = new Vector(array[i]);
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
        this.rows = new Vector[vectors.length];
        for (int i = 0; i < numberRows(); ++i) {
            this.rows[i] = new Vector(vectors[i]);
        }
    }

    public Matrix(Matrix copy) {
        this.rows = new Vector[copy.numberRows()];
        for (int i = 0; i < numberRows(); ++i) {
            this.rows[i] = new Vector(copy.rows[i]);
        }
    }

    public int numberRows() {
        return rows.length;
    }

    public int numberColumn() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector newVector) {
        if (newVector.getSize() != numberColumn()) {
            throw new IllegalArgumentException("Новый вектор другой длины");
        }
        rows[index] = new Vector(newVector);
    }

    public Vector getColumn(int index) {
        Vector newColumn = new Vector(numberRows());
        for (int i = 0; i < numberRows(); ++i) {
            newColumn.setComponent(i, rows[i].getComponent(index));
        }
        return newColumn;
    }

    public Matrix transpose() {
        int m = this.numberColumn();
        Vector[] newArrayRow = new Vector[m];
        for (int i = 0; i < m; ++i) {
            newArrayRow[i] = this.getColumn(i);
        }
        this.rows = newArrayRow;
        return this;
    }

    public Matrix multiplyScalar(double scalar) {
        for (Vector e : rows) {
            e.multiplyScalar(scalar);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < numberRows() - 1; ++i) {
            sb.append(rows[i].toString());
            sb.append(", ");
        }
        sb.append(rows[numberRows() - 1]);
        sb.append("}");
        return sb.toString();
    }

    private double indexMaxValue(int indexColumn) {
        Vector column = new Vector(getColumn(indexColumn));
        double maxValue = Math.abs(column.getComponent(0));
        int index = 0;
        for (int i = indexColumn; i < numberRows(); ++i) {
            if (Math.abs(column.getComponent(i)) > maxValue) {
                maxValue = Math.abs(column.getComponent(i));
                index = i;
            }
        }
        return index;
    }

    public double calculateDeterminate() {
        double determinate = 1;
        if (numberRows() != numberColumn()) {
            throw new IllegalArgumentException("Определителя не существует");
        }
        for (int i = 0; i < numberColumn() - 1; ++i) {
            for (int j = i + 1; j < numberRows(); ++j) {
                if (this.indexMaxValue(i) != i) {
                    Vector vector = rows[i];
                    rows[i] = new Vector(rows[j]);
                    rows[j] = new Vector(vector);
                }
                double number = rows[j].getComponent(i) / rows[i].getComponent(i);
                for (int k = i; k < numberColumn(); ++k) {
                    rows[j].setComponent(k, rows[j].getComponent(k) -
                            rows[i].getComponent(k) * number);
                }
            }
        }
        for (int i = 0; i < numberColumn(); ++i) {
            determinate *= rows[i].getComponent(i);
        }
        return determinate;
    }
}
