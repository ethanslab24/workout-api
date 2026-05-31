package com.edue.workoutapi;

public class Workout {
    private String exerciseName;
    private int sets;
    private int reps;
    private double weight;
    private String date;

    public Workout(String exerciseName, int sets, int reps, double weight, String date){
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }
}