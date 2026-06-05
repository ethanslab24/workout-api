import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [workouts, setWorkouts] = useState([])
  
  const [exerciseName, setExerciseName] = useState("")
  const [sets, setSets] = useState("")
  const [reps, setReps] = useState("")
  const [weight, setWeight] = useState("")
  const [date, setDate] = useState("")

  const [editingId, setEditingId] = useState(null)
  

  useEffect(() => {
    fetch('http://localhost:8080/workouts')
      .then(response => response.json())
      .then(data => {
      console.log(data)
      setWorkouts(data)
    })
  }, [])

  function addWorkout() {

    if (!Number.isInteger(Number(sets)) || !Number.isInteger(Number(reps))) {
        alert("Sets and reps must be whole numbers.")
        return
    }

    const addedWorkout = {
          exerciseName,
          sets: Number(sets),
          reps: Number(reps),
          weight: Number(weight),
          date
    }
    console.log(addedWorkout)
    
    if (editingId === null) {
        fetch('http://localhost:8080/workouts', {
              method: 'POST',
              headers: {'Content-Type': 'application/json'},
              body: JSON.stringify(addedWorkout)
        }).then(response => {
        if (!response.ok) {
            throw new Error("Failed to add workout")
        }
        return response.json()}).then(savedWorkout => {
        setWorkouts([...workouts, savedWorkout])})
    }else{
        fetch(`http://localhost:8080/workouts/${editingId}`, {
              method: 'PUT',
              headers: {'Content-Type': 'application/json'},
              body: JSON.stringify(addedWorkout)
        }).then(response => {
          if (!response.ok){
              throw new Error("Failed to add workout")
          }
          return response.json()}).then(savedWorkout => {
                 setWorkouts( workouts.map((workout) => workout.id === savedWorkout.id ? savedWorkout : workout
                             )
                )
           setEditingId(null)})
      }  
    }
  

  function deleteWorkout(id) {
    fetch(`http://localhost:8080/workouts/${id}`, {
          method: 'DELETE'}
    ).then(response => {
      if(!response.ok){
        throw new Error("Failed to delete workout")
      }
      setWorkouts(workouts.filter((workout) => workout.id !== id))
    })
  }

  function editWorkout(workout){
    setEditingId(workout.id)
    setExerciseName(workout.exerciseName)
    setSets(workout.sets)
    setReps(workout.reps)
    setWeight(workout.weight)
    setDate(workout.date)
  }
  
  return (
    <main>
      <h1>Workout Tracker</h1>

      <input
       type="text"
       placeholder="Exercise Name"
       value={exerciseName}
       onChange={(event) => setExerciseName(event.target.value)}
      />

      <input
       type="number"
       step="1"
       placeholder="Sets"
       value={sets}
       onChange={(event) => setSets(event.target.value)}
      />

      <input
       type="number"
       step="1"
       placeholder="Reps"
       value={reps}
       onChange={(event) => setReps(event.target.value)}
      />

      <input
       type="number"
       placeholder="Weight"
       value={weight}
       onChange={(event) => setWeight(event.target.value)}
      />

      <input
       type="date"
       value={date}
       onChange={(event) => setDate(event.target.value)}
      />

      <button onClick={addWorkout}>Add Workout</button>

      <section>
        <h2>Workouts</h2>
        {workouts.map((workout) => (
          <div key={workout.id}>
          <h3>{workout.exerciseName}</h3>
          <p>Sets: {workout.sets}</p>
          <p>Reps: {workout.reps}</p>
          <p>Weight: {workout.weight}</p>
          <p>Date: {workout.date}</p>
          <button onClick={()=> editWorkout(workout)}>Edit Workout</button>
          <button onClick={() => deleteWorkout(workout.id)}>Delete</button>
          </div>
      ))}
      </section>
    </main>
  )
}

export default App
