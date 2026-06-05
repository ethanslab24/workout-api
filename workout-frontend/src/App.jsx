import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [exerciseName, setExerciseName] = useState("")
  const [sets, setSets] = useState("")
  const [reps, setReps] = useState("")
  const [weight, setWeight] = useState("")
  const [date, setDate] = useState("")
  const [workouts, setWorkouts] = useState([])

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
          </div>
      ))}
      </section>
    </main>
  )
}

export default App
