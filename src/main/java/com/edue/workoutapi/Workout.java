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

    public Workout(){}

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