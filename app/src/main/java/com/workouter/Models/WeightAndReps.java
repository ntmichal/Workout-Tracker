package com.workouter.Models;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class WeightAndReps implements Serializable {
    private int weight;
    private int repeats;

    public WeightAndReps(){
        this.weight = 0;
        this.repeats = 0;
    }
    public WeightAndReps(int weight, int repeats) {
        this.weight = weight;
        this.repeats = repeats;
    }

    public int getWeight() {
        return weight;
    }

    public WeightAndReps setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public int getRepeats() {
        return repeats;
    }

    public WeightAndReps setRepeats(int repeats) {
        this.repeats = repeats;
        return this;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new WeightAndReps(this.weight,this.repeats);
    }
}
