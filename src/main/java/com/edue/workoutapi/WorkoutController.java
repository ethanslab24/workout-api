package com.edue.workoutapi;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Workout> findWorkoutById(@PathVariable int id) {
        Workout workout = workoutRepository.findById(id).orElse(null);
        if(workout == null) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workout);
    }

    @PostMapping("/workouts")
    public ResponseEntity<Workout> createWorkout(@Valid @RequestBody Workout workout) {
        Workout savedWorkout =  workoutRepository.save(workout);
        return ResponseEntity.created(URI.create("/workouts/" + savedWorkout.getId())).body(savedWorkout);
    }

    @DeleteMapping("/workouts/{id}")
    public ResponseEntity<Void> deleteWorkoutById(@PathVariable int id){
        Workout workoutToDel = workoutRepository.findById(id).orElse(null);
        if(workoutToDel == null)
           return ResponseEntity.notFound().build();
        workoutRepository.delete(workoutToDel);
        return ResponseEntity.noContent().build();
    }

    @Valid
    @PutMapping("/workouts/{id}")
    public ResponseEntity<Workout>editWorkoutById(@PathVariable int id, @Valid @RequestBody Workout w){
        Workout workoutToEdit = workoutRepository.findById(id).orElse(null);
        if(workoutToEdit == null)
           return ResponseEntity.notFound().build();

        workoutToEdit.setExerciseName(w.getExerciseName());
        workoutToEdit.setSets(w.getSets());
        workoutToEdit.setReps(w.getReps());
        workoutToEdit.setWeight(w.getWeight());
        workoutToEdit.setDate(w.getDate());

        workoutRepository.save(workoutToEdit);
        
        return ResponseEntity.ok(workoutToEdit);
    }

}