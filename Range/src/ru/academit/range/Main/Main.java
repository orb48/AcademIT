package ru.academit.range.Main;
;import ru.academit.range.Range.Range;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(1, 5);
        Range second = new Range(3, 8);
        Range resultIntersection = new Range();
        resultIntersection = resultIntersection.getIntersection(first, second);
        if (resultIntersection != null)
            System.out.printf("Интервал пересечения: %f, %f %n", resultIntersection.getFrom(), resultIntersection.getTo());

        Range resultAssociation = new Range();
        System.out.print("Интервал объединения: ");
        resultAssociation.getAssociation(first, second);

        Range resultDifference = new Range();
        System.out.print("Интервал разницы: ");
        resultDifference.getDifference(first, second);
    }
}


