package com.davidr10.gym.workout.domain.usecase

import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

class CreateWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(workoutId: String): Workout {
            val workout = repository.getWorkoutById(workoutId)
            val workoutLogWorkout = repository.getLastWorkoutLogWorkout(workoutId)
            return  workoutLogWorkout?.copy(id = UUID.randomUUID().toString())
                ?: workout.copy(id = UUID.randomUUID().toString())
    }
}