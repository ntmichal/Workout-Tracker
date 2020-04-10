package com.workouter.Models;


import android.icu.text.Edits;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import androidx.annotation.NonNull;

public class Workout implements Serializable {
    private String workoutName;
    private Stack<List<ExerciseModel>> exercisesModel;


    public Workout(String workoutName){
        this.workoutName = workoutName;
        this.exercisesModel = new Stack<>();
        this.exercisesModel.push(new ArrayList<ExerciseModel>());

    }
    public Workout(String workoutName, Stack<List<ExerciseModel>> exercisesModelList){
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
        return exercisesModel.peek();
    }
    public void addExercise(ExerciseModel exerciseModel){
        this.exercisesModel.peek().add(exerciseModel);
    }

    public void setExercisesModel(Stack<List<ExerciseModel>> exercisesModel) {
        this.exercisesModel = exercisesModel;
    }
    public ExerciseModel getExercise(int position){
        return this.exercisesModel.peek().get(position);
    }


    public void startNewWorkout() {
        List<ExerciseModel> exerciseModelList = exercisesModel.peek();
        List<ExerciseModel> exerciseModelListClone = new ArrayList<>();

        try {
            Iterator<ExerciseModel> exerciseModelIterator = exerciseModelList.iterator();
            while (exerciseModelIterator.hasNext()) {
                exerciseModelListClone.add((ExerciseModel) exerciseModelIterator.next().clone());
            }
        } catch (CloneNotSupportedException exception) {

        }
        exercisesModel.push(exerciseModelListClone);

    }
    public void discardWorkout(){
        exercisesModel.pop();
    }
}
