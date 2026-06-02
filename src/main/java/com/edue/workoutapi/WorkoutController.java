package com.edue.workoutapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository; 
    }

    @GetMapping("/workouts")
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll(); 
    }

    @GetMapping("/workouts/{id}")
    public Workout findWorkoutById(@PathVariable int id) {
        return workoutRepository.findById(id).orElse(null);
    }

    @PostMapping("/workouts")
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }

    @DeleteMapping("/workouts/{id}")
    public boolean deleteWorkoutById(@PathVariable int id){
        Workout workoutToDel = workoutRepository.findById(id).orElse(null);
        if(workoutToDel == null)
           return false;
        workoutRepository.delete(workoutToDel);
        return true;
    }

    @PutMapping("/workouts/{id}")
    public boolean editWorkoutById(@PathVariable int id, @RequestBody Workout w){
        Workout workoutToEdit = workoutRepository.findById(id).orElse(null);
        if(workoutToEdit == null)
           return false;

        workoutToEdit.setExerciseName(w.getExerciseName());
        workoutToEdit.setSets(w.getSets());
        workoutToEdit.setReps(w.getReps());
        workoutToEdit.setWeight(w.getWeight());
        workoutToEdit.setDate(w.getDate());

        workoutRepository.save(workoutToEdit);
        
        return true;
    }

}