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
        if (isIntersectionWithoutEnds(secondInterval)) {
            return new Range(Math.max(this.from, secondInterval.from), Math.min(this.to, secondInterval.to));
        } else {
            return null;
        }
    }

    public Range[] getAssociation(Range secondInterval) {
        Range[] list;
        if (!isIntersectionWithEnds(secondInterval)) {
            list = new Range[2];
            list[0] = this.copy();
            list[1] = secondInterval.copy();
        } else {
            list = new Range[1];
            list[0] = new Range(Math.min(this.from, secondInterval.from), Math.max(this.to, secondInterval.to));
        }
        return list;
    }

    public Range[] getDifference(Range secondInterval) {
        Range[] list;
        if (isIntersectionWithoutEnds(secondInterval)) {
            if (this.from > secondInterval.from && this.to < secondInterval.to) {
                list = null;
            } else if (this.from < secondInterval.from && secondInterval.to < this.to) {
                list = new Range[2];
                list[0] = new Range(this.from, secondInterval.from);
                list[1] = new Range(secondInterval.to, this.to);
            } else {
                list = new Range[1];
                if (this.from < secondInterval.from) {
                    list[0] = new Range(this.from, secondInterval.from);
                } else {
                    list[0] = new Range(secondInterval.to, this.to);
                }
            }
        } else {
            list = new Range[1];
            list[0] = this.copy();
        }
        return list;
    }

}