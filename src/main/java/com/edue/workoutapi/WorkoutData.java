package com.edue.workoutapi;

import java.util.ArrayList;

public class WorkoutData{
    private ArrayList<Workout> workouts = new ArrayList<>();

    public WorkoutData(){
        Workout workout1 = new Workout("Bench Press", 4, 15, 90, "05-30-26");
        Workout workout2 = new Workout("Squats", 6, 8, 60, "05-30-26");
        Workout workout3 = new Workout("Shoulder Press", 4, 18, 60, "05-30-26");

        workouts.add(workout1);
        workouts.add(workout2);
        workouts.add(workout3);
    }

    public ArrayList<Workout> getAllWorkouts(){
        return workouts;
    }
}


