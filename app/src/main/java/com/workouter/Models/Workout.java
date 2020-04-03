package com.workouter.Models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Workout implements Serializable {
    private String workoutName;
    private List<ExerciseModel> exercisesModel;


    public Workout(String workoutName){
        this.workoutName = workoutName;
        this.exercisesModel = new ArrayList<>();

    }
    public Workout(String workoutName, List<ExerciseModel> exercisesModelList){
        this.workoutName = workoutName;
        this.exercisesModel = exercisesModelList;
    }


    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public List<ExerciseModel> getExerciseModel() {
        return exercisesModel;
    }
    public void addExercise(ExerciseModel exerciseModel){
        this.exercisesModel.add(exerciseModel);
    }

    public void setExercisesModel(List<ExerciseModel> exercisesModel) {
        this.exercisesModel = exercisesModel;
    }
    public ExerciseModel getExercise(int position){
        return this.exercisesModel.get(position);
    }
}
