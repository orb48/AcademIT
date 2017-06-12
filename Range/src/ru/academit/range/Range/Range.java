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
        }
        return null;
    }

    public Range[] getAssociation(Range secondInterval) {
        if (!isIntersectionWithEnds(secondInterval)) {
            return new Range[]{this.copy(), secondInterval.copy()};
        }
        return new Range[]{new Range(Math.min(this.from, secondInterval.from), Math.max(this.to, secondInterval.to))};
    }

    public Range[] getDifference(Range secondInterval) {
        if (isIntersectionWithoutEnds(secondInterval)) {
            if (this.from > secondInterval.from && this.to < secondInterval.to) {
                return new Range[]{};
            } else if (this.from < secondInterval.from && secondInterval.to < this.to) {
                return new Range[]{new Range(this.from, secondInterval.from), new Range(secondInterval.to, this.to)};
            } else {
                if (this.from < secondInterval.from) {
                    return new Range[]{new Range(this.from, secondInterval.from)};
                } else {
                    return new Range[]{new Range(secondInterval.to, this.to)};
                }
            }
        }
        return new Range[]{this.copy()};
    }
}