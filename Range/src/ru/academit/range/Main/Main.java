package ru.academit.range.Main;
;import ru.academit.range.Range.Range;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(1, 5);
        Range second = new Range(3, 8);
        Range resultIntersection =  first.getIntersection(second);
        if (resultIntersection != null)
            System.out.printf("Интервал пересечения: %f, %f %n", resultIntersection.getFrom(), resultIntersection.getTo());

        System.out.print("Интервал объединения: ");
        ArrayList<Range> resultAssociation = first.getAssociation(second);
        for (Range e: resultAssociation) {
            System.out.printf("%f, %f %n", e.getFrom(), e.getTo());
        }

        System.out.print("Интервал разницы: ");
        ArrayList<Range> resultDifference = first.getDifference(second);
        for (Range e: resultDifference) {
            System.out.printf("%f, %f %n", e.getFrom(), e.getTo());
        }
    }
}


