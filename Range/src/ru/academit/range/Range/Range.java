package ru.academit.range.Range;

import java.util.ArrayList;

public class Range {

    private double to;
    private double from;
    public static final int COUNT_INTERVAL = 2;

    public Range(double from, double to) {
        this.to = to;
        this.from = from;
    }

    private Range(Range copy) {
        this.from = copy.from;
        this.to = copy.to;
    }

    private Range copy() {
        return new Range(this);
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
    
    private boolean isIntersectionWithoutEnds(Range secondInterval) {
        return (secondInterval.from < this.to && this.from < secondInterval.to);
    }

    private boolean isIntersectionWithEnds(Range secondInterval) {
        return (secondInterval.from <= this.to && this.from <= secondInterval.to);
    }

    public Range getIntersection(Range secondInterval) {
        Range intervalIntersection = this.copy();
        if (isIntersectionWithoutEnds(secondInterval)) {
            intervalIntersection.from = Math.max(this.from, secondInterval.from);
            intervalIntersection.to = Math.min(this.to, secondInterval.to);
            return intervalIntersection;
        } else {
            return null;
        }
    }

    public Range[] getAssociation(Range secondInterval) {
        Range[] list = new Range[COUNT_INTERVAL];
        ;
        Range intervalAssociation = this.copy();
        if (!isIntersectionWithEnds(secondInterval)) {
            list[0] = this.copy();
            list[1] = secondInterval.copy();
        } else {
            intervalAssociation.from = Math.min(this.from, secondInterval.from);
            intervalAssociation.to = Math.max(this.to, secondInterval.to);
            list[0] = intervalAssociation;
        }
        return list;
    }

    public Range[] getDifference(Range secondInterval) {
        Range[] list = new Range[COUNT_INTERVAL];
        Range intervalDifference = this.copy();
        if (isIntersectionWithoutEnds(secondInterval)) {
            intervalDifference.from = this.from;
            intervalDifference.to = secondInterval.from;
            list[0] = intervalDifference;
            if (this.to > secondInterval.to) {
                Range intervalDifferenceCopy = intervalDifference.copy();
                intervalDifferenceCopy.from = secondInterval.to;
                intervalDifferenceCopy.to = this.to;
                list[1] = intervalDifferenceCopy;
            }
        } else {
            list[0] = this.copy();
        }
        return list;
    }

}