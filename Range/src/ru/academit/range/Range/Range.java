package ru.academit.range.Range;

import java.util.ArrayList;

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

    public void print() {
        System.out.printf("%f, %f %n", this.getFrom(), this.getTo());
    }

    private boolean isIntersection(Range secondInterval) {
        return (secondInterval.from <= this.to && this.from <= secondInterval.to);
    }

    public Range getIntersection(Range secondInterval) {
        Range intervalIntersection = new Range();
        if (isIntersection(secondInterval)) {
            intervalIntersection.from = Math.max(this.from, secondInterval.from);
            intervalIntersection.to = Math.min(this.to, secondInterval.to);
            return intervalIntersection;
        } else {
            return null;
        }
    }

    public ArrayList getAssociation(Range secondInterval) {
        ArrayList<Range> list = new ArrayList<Range>();
        if (!isIntersection(secondInterval)) {
            list.add(this);
            list.add(secondInterval);
        } else {
            this.from = Math.min(this.from, secondInterval.from);
            this.to = Math.max(this.to, secondInterval.to);
            list.add(this);
        }
        return list;
    }

    public ArrayList getDifference(Range secondInterval) {
        ArrayList<Range> list = new ArrayList<Range>();
        Range intervalDifference = new Range();
        if (isIntersection(secondInterval)) {
            intervalDifference.from = this.from;
            intervalDifference.to = secondInterval.from;
            list.add(intervalDifference);
            if (this.to > secondInterval.to) {
                intervalDifference.from = secondInterval.to;
                intervalDifference.to = this.to;
                list.add(intervalDifference);
            }
        }
        if (!isIntersection(secondInterval)) {
            list.add(this);
        }
        return list;
    }

}