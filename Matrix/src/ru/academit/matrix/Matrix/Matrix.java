package ru.academit.matrix.Matrix;

import ru.academit.vector.Vector.Vector;

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
        for (int i = 0; i < getNumberRows(); ++i) {
            this.rows[i] = new Vector(vectors[i]);
        }
    }

    public Matrix(Matrix copy) {
        this.rows = new Vector[copy.getNumberRows()];
        for (int i = 0; i < getNumberRows(); ++i) {
            this.rows[i] = new Vector(copy.rows[i]);
        }
    }

    public int getNumberRows() {
        return rows.length;
    }

    public int getNumberColumn() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector newVector) {
        if (newVector.getSize() != getNumberColumn()) {
            throw new IllegalArgumentException("Новый вектор другой длины");
        }
        rows[index] = new Vector(newVector);
    }

    public Vector getColumn(int index) {
        Vector newColumn = new Vector(getNumberRows());
        for (int i = 0; i < getNumberRows(); ++i) {
            newColumn.setComponent(i, rows[i].getComponent(index));
        }
        return newColumn;
    }

    //Транспонировать матрицу
    public Matrix transpose() {
        int m = this.getNumberColumn();
        Vector[] newArrayRow = new Vector[m];
        for (int i = 0; i < m; ++i) {
            newArrayRow[i] = this.getColumn(i);
        }
        this.rows = newArrayRow;
        return this;
    }

    //Умножить на скаляр
    public Matrix multiplyScalar(double scalar) {
        for (Vector e : rows) {
            e.multiplyScalar(scalar);
        }
        return this;
    }

    //Преобразование в строку
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < getNumberRows() - 1; ++i) {
            sb.append(rows[i].toString());
            sb.append(", ");
        }
        sb.append(rows[getNumberRows() - 1]);
        sb.append("}");
        return sb.toString();
    }

    //Вспомогательный метод, найти индекс максимального элемента в столбце
    private double getIndexMaxValue(int indexColumn) {
        Vector column = getColumn(indexColumn);
        double maxValue = Math.abs(column.getComponent(0));
        int index = 0;
        for (int i = indexColumn; i < getNumberRows(); ++i) {
            if (Math.abs(column.getComponent(i)) > maxValue) {
                maxValue = Math.abs(column.getComponent(i));
                index = i;
            }
        }
        return index;
    }

    //Посчитать определитель
    public double calculateDeterminate() {
        Matrix matrix = new Matrix(this);
        double determinate = 1;
        if (matrix.getNumberRows() != matrix.getNumberColumn()) {
            throw new IllegalArgumentException("Определителя не существует");
        }
        for (int i = 0; i < matrix.getNumberColumn() - 1; ++i) {
            for (int j = i + 1; j < matrix.getNumberRows(); ++j) {
                if (matrix.getIndexMaxValue(i) != i) {
                    Vector vector = matrix.rows[i];
                    matrix.rows[i] = new Vector(matrix.rows[j]);
                    matrix.rows[j] = new Vector(vector);
                }
                double number = matrix.rows[j].getComponent(i) / matrix.rows[i].getComponent(i);
                for (int k = i; k < matrix.getNumberColumn(); ++k) {
                    matrix.rows[j].setComponent(k, matrix.rows[j].getComponent(k) -
                            matrix.rows[i].getComponent(k) * number);
                }
            }
            if (matrix.rows[i].getComponent(i) == 0) {
                return 0;
            }
        }
        for (int i = 0; i < matrix.getNumberColumn(); ++i) {
            determinate *= matrix.rows[i].getComponent(i);
        }
        return determinate;
    }

    //Умножение матрицы на вектор
    public Vector multiplyVector(Vector vector) {
        if (getNumberColumn() != vector.getSize()) {
            throw new IllegalArgumentException("Размерность вектора должна совпадать с количеством столбцов матрицы");
        }
        Vector result = new Vector(getNumberRows());
        double sumComponentsRow = 0;
        for (int i = 0; i < getNumberRows(); ++i) {
            for (int j = 0; j < getNumberColumn(); ++j) {
                sumComponentsRow += rows[i].getComponent(j) * vector.getComponent(j);
            }
            result.setComponent(i, sumComponentsRow);
        }
        return result;
    }

}
