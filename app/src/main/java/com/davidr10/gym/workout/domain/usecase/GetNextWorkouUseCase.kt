package com.davidr10.gym.workout.domain.usecase

import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNextWorkouUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: String): Workout {
        return withContext(Dispatchers.IO){
            val workouts = repository.getAlltWorkoutsByRoutine(routineId)
            val workout = workouts.first()
            println(workout)

             repository.getWorkoutById(workouts.first())
        }
    }
}