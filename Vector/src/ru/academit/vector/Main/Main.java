package ru.academit.vector.Main;

import ru.academit.vector.Vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector coordinates = new Vector(new double[]{1.0, 2.0, 6.0, 5.0});
        System.out.println("Вектор 1: " + coordinates.toString());

        Vector coordinatesCopy = new Vector(coordinates);
        System.out.println("Копия: " + coordinatesCopy.toString());

        Vector coordinates2 = new Vector(6, new double[]{6, 2, 13, 5, 1});
        System.out.println("Вектор 2: " + coordinates2.toString());

        //сумма векторов
        System.out.println("Сумма векторов: " + coordinates.vectorsSum(coordinates2));
        System.out.println("Сумма других векторов" + Vector.vectorsSumStatic(coordinates, coordinates2));

        //разность векторов
        System.out.println("Разность векторов: " + coordinates2.vectorsDifference(coordinates));
        System.out.println("Разность векторов: " + Vector.vectorsDifferenceStatic(coordinates, coordinates2));

        //Скалярное произведение
        System.out.println("Скалярное произведение: " + Vector.vectorsScalarProduct(coordinates, coordinates2));

        //Умножение на скаляр
        System.out.println("Умножение на скаляр: " + coordinates.multiplyScalar(2));
        System.out.println("Развернутый вектор: " + coordinates.expandVector());

        //Длина вектора
        Vector coordinates3 = new Vector(new double[]{1.0, 2.0, 1.0});
        System.out.println("Длина вектора: " + coordinates3.getLengthVector());

        //Получение и установка компоненты вектора по индексу
        System.out.println("Компонента вектора: " + coordinates3.getVectorComponents(2));

    }
}
