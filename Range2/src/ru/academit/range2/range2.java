package ru.academit.range2;

public class range2 {

    private double to;
    private double from;

    public range2() {
    }

    public range2(double from, double to) {
        this.to = to;
        this.from = from;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public void print(range2 interval) {
        System.out.printf("%f, %f %n", interval.getFrom(), interval.getTo());
    }

    public boolean isIntersection(range2 firstInterval, range2 secondInterval) {
        return (secondInterval.from <= firstInterval.to && firstInterval.from <= secondInterval.to);
    }

    public range2 getIntersection(range2 firstInterval, range2 secondInterval) {
        range2 intervalIntersection = new range2();
        if (isIntersection(firstInterval, secondInterval)) {
            intervalIntersection.from = Math.max(firstInterval.from, secondInterval.from);
            intervalIntersection.to = Math.min(firstInterval.to, secondInterval.to);
            return intervalIntersection;
        } else {
            return null;
        }
    }

    public void getAssociation(range2 firstInterval, range2 secondInterval) {
        range2 intervalAssociation = new range2();
        if (!isIntersection(firstInterval, secondInterval)) {
            print(firstInterval);
            print(secondInterval);
        } else {
            intervalAssociation.from = Math.min(firstInterval.from, secondInterval.from);
            intervalAssociation.to = Math.max(firstInterval.to, secondInterval.to);
            print(intervalAssociation);
        }
    }

    public void getDifference(range2 firstInterval, range2 secondInterval) {
        range2 intervalDifference = new range2();
        if (isIntersection(firstInterval, secondInterval)) {
            intervalDifference.from = firstInterval.from;
            intervalDifference.to = secondInterval.from;
            print(intervalDifference);
            if (firstInterval.to > secondInterval.to) {
                intervalDifference.from = secondInterval.to;
                intervalDifference.to = firstInterval.to;
                print(intervalDifference);
            }
        }
        if (!isIntersection(firstInterval, secondInterval)) {
            print(firstInterval);
        }
    }

}