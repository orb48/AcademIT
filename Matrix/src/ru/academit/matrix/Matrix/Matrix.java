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
    private int getIndexMaxValue(int indexColumn) {
        Vector column = getColumn(indexColumn);
        double maxValue = Math.abs(column.getComponent(indexColumn));
        int index = indexColumn;
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
        int numberPermutationsRows = 0;
        for (int i = 0; i < matrix.getNumberColumn() - 1; ++i) {
            for (int j = i + 1; j < matrix.getNumberRows(); ++j) {
                if (matrix.getIndexMaxValue(i) != i) {
                    Vector vector = matrix.rows[i];
                    matrix.rows[i] = matrix.rows[j];
                    matrix.rows[j] = vector;
                    ++numberPermutationsRows;
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
        if (numberPermutationsRows % 2 != 0) {
            return -determinate;
        }
        return determinate;
    }

    //Умножение матрицы на вектор
    public Vector multiplyVector(Vector vector) {
        if (getNumberColumn() != vector.getSize()) {
            throw new IllegalArgumentException("Размерность вектора должна совпадать с количеством столбцов матрицы");
        }
        Vector result = new Vector(getNumberRows());
        for (int i = 0; i < getNumberRows(); ++i) {
            double sumComponentsRow = 0;
            for (int j = 0; j < getNumberColumn(); ++j) {
                sumComponentsRow += rows[i].getComponent(j) * vector.getComponent(j);
            }
            result.setComponent(i, sumComponentsRow);
        }
        return result;
    }

    //Сложение матрицы
    public Matrix add(Matrix matrix) {
        for (int i = 0; i < getNumberRows(); ++i) {
            this.rows[i].add(matrix.rows[i]);
        }
        return this;
    }

    //Разность матриц
    public Matrix getDifference(Matrix matrix) {
        for (int i = 0; i < getNumberRows(); ++i) {
            this.rows[i].getDifference(matrix.rows[i]);
        }
        return this;
    }

    //Static Сложение матрицы
    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        return matrix1Copy.add(matrix2);
    }

    //Static Разность матриц
    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        return matrix1Copy.getDifference(matrix2);
    }

    //Static Умножение матриц
    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getNumberColumn() != matrix2.getNumberRows()) {
            throw new IllegalArgumentException("Размерность вектора должна совпадать с количеством столбцов матрицы");
        }
        Vector[] result = new Vector[(matrix1.getNumberRows())];
        for (int i = 0; i < matrix1.getNumberRows(); ++i) {
            result[i] = matrix1.multiplyVector(matrix2.getColumn(i));
        }
        return new Matrix(result).transpose();
    }
}
