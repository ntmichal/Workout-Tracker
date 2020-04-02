package com.workouter.Models;

import com.workouter.ExerciseType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExerciseModel implements Serializable {
    private int id;
    private String exerciseName;
    private ExerciseType exerciseType;
    private List<WeightAndReps> weightAndRepsList;

    public ExerciseModel(int id, String exerciseName){
        this.id = id;
        this.exerciseName = exerciseName;
        this.weightAndRepsList = new ArrayList<>();
        this.weightAndRepsList.add(new WeightAndReps());
        this.weightAndRepsList.add(new WeightAndReps());

    }
    public ExerciseModel(int id, String exerciseName, List<WeightAndReps> weightAndRepsList){
        this.id = id;
        this.exerciseName = exerciseName;
        this.weightAndRepsList = weightAndRepsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public List<WeightAndReps> getWeightAndRepsList() {
        return weightAndRepsList;
    }

    public void setWeightAndRepsList(List<WeightAndReps> weightAndRepsList) {
        this.weightAndRepsList = weightAndRepsList;
    }

    public void setWeightAndReps(int position, int weight, int reps){
        this.weightAndRepsList.get(position).setWeight(weight).setRepeats(reps);
    }
    public void addSet(){
        this.weightAndRepsList.add(new WeightAndReps());
    }

    public class ExerciseBuilder{
        private int id;
        private String exerciseName;
        private List<WeightAndReps> weightAndRepsList;


    }
}
