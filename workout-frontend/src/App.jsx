import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [workouts, setWorkouts] = useState([])

useEffect(() => {
  fetch('http://localhost:8080/workouts')
    .then(response => response.json())
    .then(data => {
      console.log(data)
      setWorkouts(data)
    })
}, [])
  

  return (
    <main>
      <h1>Workout Tracker</h1>

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
