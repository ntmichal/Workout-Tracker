package com.workouter;

import com.workouter.Models.ExerciseModel;
import com.workouter.Models.Workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutDataHolder{
    private String name;
    private List<Workout> workoutList;
    public static final WorkoutDataHolder workoutDataHolder = new WorkoutDataHolder();

    public static WorkoutDataHolder getInstance(){
        return workoutDataHolder;
    }

    private WorkoutDataHolder(){
        workoutList = new ArrayList<>();

        Workout workout = new Workout("Sets and Reps");
        ExerciseModel exerciseModel1 = new ExerciseModel(0,"Pull ups");
        ExerciseModel exerciseModel2 = new ExerciseModel(1,"Chin ups");
        ExerciseModel exerciseModel3 = new ExerciseModel(2,"Pushups");
        workout.addExercise(exerciseModel1);
        workout.addExercise(exerciseModel2);
        workout.addExercise(exerciseModel3);

        Workout workout1 = new Workout("Sets nad Reps 2");
        ExerciseModel exerciseModel4 = new ExerciseModel(0,"Pull ups");
        ExerciseModel exerciseModel5 = new ExerciseModel(1,"Chin ups");
        ExerciseModel exerciseModel6 = new ExerciseModel(2,"Pushups");
        workout1.addExercise(exerciseModel4);
        workout1.addExercise(exerciseModel5);
        workout1.addExercise(exerciseModel6);

        workoutList.add(workout);
        workoutList.add(workout1);
    }

    public List<Workout> getWorkouts(){
        return workoutList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addWorkout(Workout workout){
        this.workoutList.add(workout);
    }

    public WorkoutBuilder builder(){
        return new WorkoutBuilder();
    }

    public class WorkoutBuilder{
        private String name;
        private List<ExerciseModel> exerciseModelList = new ArrayList<>();

        public WorkoutBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public WorkoutBuilder addExercise(ExerciseModel exerciseModel){
            this.exerciseModelList.add(exerciseModel);
            return this;
        }

        public void build(){
            Workout workout = new Workout(this.name);
            workout.setExercisesModel(this.exerciseModelList);
            WorkoutDataHolder.getInstance().addWorkout(workout);
        }
    }

}
