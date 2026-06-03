package com.edue.workoutapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Workout {
    
    @Id
    @GeneratedValue
    private int id;
    
    @NotBlank
    private String exerciseName;
    @Positive
    private int sets;
    @Positive
    private int reps;
    @PositiveOrZero
    private double weight;
    @NotBlank
    private String date;

    public Workout(String exerciseName, int sets, int reps, double weight, String date){
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    //no arg constructor
    public Workout(){}

    //getters
    public int getId(){
        return this.id;
    }
    
    public String getExerciseName(){
        return this.exerciseName;
    }
    public int getSets(){
        return this.sets;
    }
    
    public int getReps(){
        return this.reps;
    }
    
    public double getWeight(){
        return this.weight;
    }
    
    public String getDate(){
        return this.date;
    }

    //setters
     public void setId(int id) {
        this.id = id;
    }
    
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDate(String date) {
        this.date = date;
    }
}