package com.workouter;

import com.workouter.Models.ExerciseTemplate;

import java.util.ArrayList;
import java.util.List;

public class ExercisesHolder {

    List<ExerciseTemplate> exerciseTemplateList;
    public static final ExercisesHolder exerciseHoder = new ExercisesHolder();
    public static ExercisesHolder getInstance(){ return exerciseHoder;}

    private ExercisesHolder(){
        exerciseTemplateList = new ArrayList<>();
        this.addExercise("Bench Press", ExerciseType.Chest);
        this.addExercise("Chest Dip", ExerciseType.Chest);
        this.addExercise("Decline Bench Press", ExerciseType.Chest);
        this.addExercise("Incline Bench Press", ExerciseType.Chest);
        this.addExercise("Incline Chest Fly", ExerciseType.Chest);
        this.addExercise("Push Up", ExerciseType.Chest);
        this.addExercise("Decline Push Up", ExerciseType.Chest);
    }
    public void addExercise(String name, ExerciseType type){
        exerciseTemplateList.add(ExerciseTemplate
                                    .builder()
                                    .setName(name)
                                    .setExerciseType(type)
                                    .build());
    }

    public List<ExerciseTemplate> getExerciseTemplateList(){
        return exerciseTemplateList;
    }
    public ExerciseTemplate getExerciseByPosition(int position){
        return exerciseTemplateList.get(position);
    }
}
