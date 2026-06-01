package com.edue.workoutapi;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private WorkoutData workoutData = new WorkoutData();

    @GetMapping("/workouts")
    public ArrayList<Workout> getWorkouts() {
        return workoutData.getAllWorkouts();
    }
}