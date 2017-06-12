package ru.academit.range.Main;

import ru.academit.range.Range.Range;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(1, 4);
        Range second = new Range(3, 8);
        Range resultIntersection = first.getIntersection(second);
        if (resultIntersection != null) {
            System.out.printf("Интервал пересечения: %f, %f %n", resultIntersection.getFrom(), resultIntersection.getTo());
        }

        System.out.print("Интервал объединения: ");
        Range[] resultAssociation = first.getAssociation(second);
        for (Range e : resultAssociation) {
            System.out.printf("%f, %f %n", e.getFrom(), e.getTo());
        }

        System.out.print("Интервал разницы: ");
        Range[] resultDifference = first.getDifference(second);
        if (resultDifference.length == 0) {
            System.out.println("Разница = 0");
        } else {
            for (Range e : resultDifference) {
                System.out.printf("%f, %f %n", e.getFrom(), e.getTo());
            }
        }

    }
}


