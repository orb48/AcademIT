package ru.academit.matrix.Main;


import ru.academit.matrix.Matrix.Matrix;
import ru.academit.vector.Vector.Vector;

public class Main {
    public static void main(String[] args) {

        Matrix matrix1 = new Matrix(4, 3);
        System.out.println("Матрица1 = " + matrix1);

        double[][] array = {{1, 2, 3}, {3, 2, 1}, {1, 1, 1}, {0, 1, 1}};
        Matrix matrix2 = new Matrix(array);
        System.out.println("Матрица2 = " + matrix2);

        Vector[] vectors = new Vector[]{new Vector(new double[]{1, 2, 3, 2}),
                new Vector(new double[]{7, 2, 0, 3}), new Vector(new double[]{1, 1, 0, 1})};
        Matrix matrix3 = new Matrix(vectors);
        System.out.println("Матрица3 = " + matrix3);
        vectors[1].setComponent(2, 1);

        Matrix matrix4 = new Matrix(matrix3);
        System.out.println(matrix3);
        System.out.println("Матрица4 = " + matrix4);

        matrix4.setRow(2, new Vector(new double[]{0, 1, 1, 2}));
        System.out.println("Вектор строка матрицы4 по индексу 2 = " + matrix4.getRow(2));

        System.out.println("Вектор строка матрицы4 по индексу 0 = " + matrix4.getColumn(0));

        double[][] array1 = {{7, 3}, {0, 2}, {4, 1}};
        Matrix matrix5 = new Matrix(array1);
        System.out.println(matrix5.transpose());

        System.out.println("Умножить на скаляр: " + matrix5.multiplyScalar(2));

        double[][] array11 = {{4, 1, 1, 3}, {3, 1, 2, 1}, {0, 0, 1, 0}, {0, 0, 3, 2}};
        Matrix matrix22 = new Matrix(array11);
        System.out.println("Определитель = " + matrix22.calculateDeterminate());

        System.out.println(matrix3);
        System.out.println(matrix3.multiplyVector(new Vector(new double[] {1, 2, 3, 5})));

        double[][] arrayAdd1 = {{1, 3, 1}, {2, 1, 5}, {0, 1, 1}};
        Matrix matrixAdd1 = new Matrix(arrayAdd1);
        double[][] arrayAdd2 = {{5, 3, 1}, {1, 1, 5}, {0, 1, 1}};
        Matrix matrixAdd2 = new Matrix(arrayAdd2);
        System.out.println(Matrix.add(matrixAdd1, matrixAdd2));
        System.out.println(matrixAdd1.getDifference(matrixAdd2));
        System.out.println(matrixAdd1.multiplyVector(new Vector(new double[]{5, 1, 0})));
        System.out.println("Умножение матриц: " + Matrix.multiplyMatrix(matrixAdd1, matrixAdd2));
    }
}
