package de.hska.iwi.ads.solution.sorting;

public class StabilityCheck implements Comparable<StabilityCheck> {

    private int value;
    private int id;

    public StabilityCheck (int value, int id) {
        this.value = value;
        this.id = id;
    }

    public int getId () {
        return this.id;
    }

    public int getValue () {
        return this.value;
    }

    @Override
    public int compareTo(StabilityCheck o) {
        int output;
        if (this.value == o.getValue())
            output = 0;
        else if (this.value < o.getValue())
            output = -1;
        else output = 1;
        return output;
        }
    }
