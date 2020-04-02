package com.workouter.Models;

import com.workouter.ExerciseType;

public class ExerciseTemplate {
    private int id;
    private String name;
    private ExerciseType exerciseType;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public static ExerciseTemplateBuilder builder(){
        return new ExerciseTemplateBuilder();
    }

    public static final class ExerciseTemplateBuilder{
        private int id;
        private String name;
        private ExerciseType exerciseType;

        public ExerciseTemplateBuilder setId(int id){
            this.id = id;
            return this;
        }
        public  ExerciseTemplateBuilder setName(String name){
            this.name = name;
            return this;
        }
        public ExerciseTemplateBuilder setExerciseType(ExerciseType exerciseType){
            this.exerciseType = exerciseType;
            return this;
        }

        public ExerciseTemplate build(){
            ExerciseTemplate exerciseTemplate = new ExerciseTemplate();
            exerciseTemplate.id = this.id;
            exerciseTemplate.exerciseType = this.exerciseType;
            exerciseTemplate.name = this.name;

            return exerciseTemplate;
        }

    }
}
