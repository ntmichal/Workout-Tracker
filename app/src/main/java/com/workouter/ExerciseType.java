package com.workouter;

import androidx.annotation.NonNull;

public enum ExerciseType {
    Core("Core"),
    Arms("Arms"),
    Back("Back"),
    Chest("Chest"),
    Legs("Legs"),
    Shoulders("Shoulders"),
    Cardio("Cardio");

    private String name;
    ExerciseType(String name){
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
