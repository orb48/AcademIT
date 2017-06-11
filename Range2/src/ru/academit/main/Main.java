package ru.academit.main;

import ru.academit.range2.range2;

public class Main {
    public static void main(String[] args) {
        range2 first = new range2(1, 5);
        range2 second = new range2(3, 8);
        range2 resultIntersection = new range2();
        resultIntersection = resultIntersection.getIntersection(first, second);
        if (resultIntersection != null)
            System.out.printf("Интервал пересечения: %f, %f %n", resultIntersection.getFrom(), resultIntersection.getTo());

        range2 resultAssociation = new range2();
        System.out.print("Интервал объединения: ");
        resultAssociation.getAssociation(first, second);

        range2 resultDifference = new range2();
        System.out.print("Интервал разницы: ");
        resultDifference.getDifference(first, second);
    }
}
