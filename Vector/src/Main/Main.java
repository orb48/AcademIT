package Main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector coordinates = new Vector(new double[]{1.0, 2.0, 6.0, 5.0});
        System.out.println("Вектор 1: " + coordinates.getSize());
        System.out.println(coordinates.toString());

        Vector coordinatesCopy = new Vector(coordinates);
        System.out.println("Копия: " + coordinatesCopy.getSize());
        System.out.println(coordinatesCopy.toString());

        Vector coordinates2 = new Vector(6, new double[]{6, 2, 13, 5, 1});
        System.out.println("Вектор 2: " + coordinates2.getSize());
        System.out.println(coordinates2.toString());

        //сумма векторов
        System.out.println("Сумма векторов: " + coordinates.vectorsSum(coordinates2).toString());
        System.out.println("Сумма других векторов" + Arrays.toString(Vector.vectorsSum(new double[]{0, 1, 2}, new double[]{1, 3, 0, 2})));
    }
}
