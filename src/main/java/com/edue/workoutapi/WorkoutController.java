package com.edue.workoutapi;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private WorkoutData workoutData = new WorkoutData();

    @GetMapping("/workouts")
    public ArrayList<Workout> getWorkouts() {
        return workoutData.getAllWorkouts();
    }

    @GetMapping("/workouts/{id}")
    public Workout getWorkoutById(@PathVariable int id){
        return workoutData.getWorkoutById(id);
    }

    @PostMapping("/workouts")
    public Workout addWorkout(@RequestBody Workout w){
        workoutData.addWorkout(w);
        return w;
    }
}