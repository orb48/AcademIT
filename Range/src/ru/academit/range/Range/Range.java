package ru.academit.range.Range;

public class Range {

    private double to;
    private double from;

    public Range() {
    }

    public Range(double from, double to) {
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

    public void print(Range interval) {
        System.out.printf("%f, %f %n", interval.getFrom(), interval.getTo());
    }

    public boolean isIntersection(Range firstInterval, Range secondInterval) {
        return (secondInterval.from <= firstInterval.to && firstInterval.from <= secondInterval.to);
    }

    public Range getIntersection(Range firstInterval, Range secondInterval) {
        Range intervalIntersection = new Range();
        if (isIntersection(firstInterval, secondInterval)) {
            intervalIntersection.from = Math.max(firstInterval.from, secondInterval.from);
            intervalIntersection.to = Math.min(firstInterval.to, secondInterval.to);
            return intervalIntersection;
        } else {
            return null;
        }
    }

    public void getAssociation(Range firstInterval, Range secondInterval) {
        Range intervalAssociation = new Range();
        if (!isIntersection(firstInterval, secondInterval)) {
            print(firstInterval);
            print(secondInterval);
        } else {
            intervalAssociation.from = Math.min(firstInterval.from, secondInterval.from);
            intervalAssociation.to = Math.max(firstInterval.to, secondInterval.to);
            print(intervalAssociation);
        }
    }

    public void getDifference(Range firstInterval, Range secondInterval) {
        Range intervalDifference = new Range();
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