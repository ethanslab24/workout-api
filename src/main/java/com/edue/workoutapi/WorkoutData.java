package com.edue.workoutapi;

import java.util.ArrayList;

public class WorkoutData{
    private ArrayList<Workout> workouts = new ArrayList<>();
    private int nextId = 1;

    public WorkoutData(){
       addWorkout(new Workout("Bench Press", 4, 15, 90, "05-30-26"));
       addWorkout(new Workout("Squats", 6, 8, 60, "05-30-26"));
       addWorkout(new Workout("Shoulder Press", 4, 18, 60, "05-30-26"));
    }

    public ArrayList<Workout> getAllWorkouts(){
        return workouts;
    }

    public Workout getWorkoutById(int id){
        for(Workout w : workouts){
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }
    
    public void addWorkout(Workout workout){
        workout.setId(nextId);
        nextId++;
        workouts.add(workout);
    }
}


