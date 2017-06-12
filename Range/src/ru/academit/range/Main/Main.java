package ru.academit.range.Main;

;import ru.academit.range.Range.Range;

import java.util.ArrayList;

import static ru.academit.range.Range.Range.COUNT_INTERVAL;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(1, 5);
        Range second = new Range(3, 4);
        Range resultIntersection = first.getIntersection(second);
        if (resultIntersection != null) {
            System.out.printf("Интервал пересечения: %f, %f %n", resultIntersection.getFrom(), resultIntersection.getTo());
        }

        System.out.print("Интервал объединения: ");
        Range[] resultAssociation = first.getAssociation(second);
        int i = 0;
        while (i < COUNT_INTERVAL && resultAssociation[i] != null) {
            System.out.printf("%f, %f %n", resultAssociation[i].getFrom(), resultAssociation[i].getTo());
            i++;
        }

        System.out.print("Интервал разницы: ");
        Range[] resultDifference = first.getDifference(second);
        i = 0;
        while (i < COUNT_INTERVAL && resultDifference[i] != null) {
            System.out.printf("%f, %f %n", resultDifference[i].getFrom(), resultDifference[i].getTo());
            i++;
        }
    }
}


